package com.example.home_automation.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(
    entities = [Device::class, SensorData::class],
    version = 2,
    exportSchema = false
)
abstract class HomeAutomationDatabase : RoomDatabase() {

    abstract fun deviceDao(): DeviceDao
    abstract fun sensorDao(): SensorDao

    private class HomeAutomationDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.deviceDao())
                }
            }
        }

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    ensureDevicesExist(database.deviceDao())
                }
            }
        }

        suspend fun populateDatabase(deviceDao: DeviceDao) {
            // Delete all content here.
            deviceDao.deleteAllDevices()

            // Add sample devices
            var device = Device("fan1", "Living Room Fan", "fan", false)
            deviceDao.insertDevice(device)

            device = Device("fan2", "Bedroom Fan", "fan", false)
            deviceDao.insertDevice(device)

            device = Device("fan3", "Kitchen Fan", "fan", false)
            deviceDao.insertDevice(device)

            device = Device("light1", "Main Light", "light", false)
            deviceDao.insertDevice(device)
        }

        suspend fun ensureDevicesExist(deviceDao: DeviceDao) {
            // Check and insert devices if they don't exist
            val deviceIds = listOf("fan1", "fan2", "fan3", "light1")
            val deviceNames = listOf("Living Room Fan", "Bedroom Fan", "Kitchen Fan", "Main Light")
            val deviceTypes = listOf("fan", "fan", "fan", "light")

            for (i in deviceIds.indices) {
                val existingDevice = deviceDao.getDevice(deviceIds[i])
                if (existingDevice == null) {
                    val device = Device(deviceIds[i], deviceNames[i], deviceTypes[i], false)
                    deviceDao.insertDevice(device)
                }
            }
        }
    }

    companion object {
        // Singleton prevents multiple instances of database opening at the same time.
        @Volatile
        private var INSTANCE: HomeAutomationDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): HomeAutomationDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HomeAutomationDatabase::class.java,
                    "home_automation_database"
                )
                .addCallback(HomeAutomationDatabaseCallback(scope))
                .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
