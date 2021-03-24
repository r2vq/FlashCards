package com.keanequibilan.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.keanequibilan.database.entity.FlashCardEntity

@Dao
interface FlashCardDao {
    @Query("SELECT * FROM FlashCardEntity")
    suspend fun getAll(): List<FlashCardEntity>

    @Insert
    suspend fun insertAll(vararg card: FlashCardEntity)

    @Query("DELETE FROM FlashCardEntity WHERE `id` = :id")
    fun delete(id: Int)
}
