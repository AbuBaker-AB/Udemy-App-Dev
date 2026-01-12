package com.example.profiler.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.profiler.data.entity.ProfileEntity

@Dao
interface ProfileDao {

    @Insert
    suspend fun insertProfile(profile: ProfileEntity)

    @Query("SELECT * FROM profiles ORDER BY id DESC")
    suspend fun getAllProfiles(): List<ProfileEntity>

    @Query("SELECT * FROM profiles WHERE id = :profileId LIMIT 1")
    suspend fun getProfileById(profileId: Int): ProfileEntity?

    @Query("DELETE FROM profiles WHERE id = :profileId")
    suspend fun deleteById(profileId: Int)

    @androidx.room.Update
    suspend fun updateProfile(profile: ProfileEntity)
}

/*
💡 What is DAO?
    DAO is the part that talks to the database.

Entity = Table
DAO = Queries (insert / read / delete / update)

Example:
    • Insert a profile
    • Get all profiles
    • Get one profile by ID
    • Delete a profile
 */


/*
✅ What you learned here (important)
    - @Dao tells Room: “this is database query interface”

    - @Insert inserts profile into table

    - @Query runs SQL query

    - 'suspend' means this runs in background (good practice)
 */