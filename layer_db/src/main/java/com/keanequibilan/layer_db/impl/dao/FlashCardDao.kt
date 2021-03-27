package com.keanequibilan.layer_db.impl.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.keanequibilan.layer_db.impl.entity.FlashCardEntity

@Dao
internal interface FlashCardDao {
    @Query("SELECT * FROM FlashCardEntity")
    suspend fun getAll(): List<FlashCardEntity>

    @Query("SELECT * FROM FlashCardEntity WHERE `id` = :id")
    suspend fun get(id: Int): FlashCardEntity?

    @Insert
    suspend fun insertAll(vararg card: FlashCardEntity)

    @Query("DELETE FROM FlashCardEntity WHERE `id` = :id")
    fun delete(id: Int)
}
