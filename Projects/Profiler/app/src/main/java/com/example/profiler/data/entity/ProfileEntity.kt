package com.example.profiler.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profiles")
data class ProfileEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val fullName: String,
    val dob: String,
    val phone: String,
    val email: String,
    val address: String

)

/*
✅ What you learned here (important)
    - @Entity means Room will create a table

    - tableName = "profiles" means the table name will be profiles

    - @PrimaryKey is unique ID

    - autoGenerate = true means Room will generate new ID automatically
 */