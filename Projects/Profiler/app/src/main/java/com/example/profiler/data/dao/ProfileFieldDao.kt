package com.example.profiler.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.profiler.data.entity.ProfileFieldEntity

@Dao
interface ProfileFieldDao {

    @Insert
    suspend fun insertField(field: ProfileFieldEntity)

    @Query("SELECT * FROM profile_fields WHERE profileId = :profileId ORDER BY id DESC")
    suspend fun getFieldsForProfile(profileId: Int): List<ProfileFieldEntity>

    @Query("DELETE FROM profile_fields WHERE id = :fieldId")
    suspend fun deleteFieldById(fieldId: Int)
}
