package com.example.profiler.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.profiler.data.dao.ProfileDao
import com.example.profiler.data.entity.ProfileEntity
import com.example.profiler.data.entity.ProfileFieldEntity
import com.example.profiler.data.dao.ProfileFieldDao

@Database(entities = [ProfileEntity::class, ProfileFieldEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun profileDao(): ProfileDao
    abstract fun profileFieldDao(): ProfileFieldDao
}

/*
💡 What is this?
    This class is the main database holder.

Room needs one class that says:
    • Which tables (entities) exist
    • Which DAOs exist
 */

/*
✅ Explanation
    • @Database(...) is like telling Room:
       ✅ “Create a database with these tables”
    • entities = [ProfileEntity::class] means our database has profiles table
    • profileDao() gives access to queries in ProfileDao
 */