package com.example.profiler.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile_fields")
data class ProfileFieldEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val profileId: Int,      // which profile this field belongs to
    val fieldKey: String,    // e.g. Blood Group
    val fieldValue: String   // e.g. O+
)
