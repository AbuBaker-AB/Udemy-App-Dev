package com.example.profiler.data.db

import android.content.Context
import androidx.room.Room

object DatabaseProvider {

    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "profiler_db"
                    ).fallbackToDestructiveMigration(false).build()
        }
        return INSTANCE!!
    }
}

/*
💡 Why we need this?
    Because you can’t use AppDatabase() directly.

Room database must be created like:
[
    kotlin Code:
    Room.databaseBuilder(...)
    ]
And we must create it once only, not again and again.
So we create a Singleton Provider.
 */

/*
✅ What you learned here
    • object makes it Singleton
    • INSTANCE stores one database object
    • getDatabase() gives DB from anywhere
    • context.applicationContext avoids memory leak
 */