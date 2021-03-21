package com.keanequibilan.database.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.keanequibilan.database.entity.FlashCardEntity

@Dao
interface FlashCardDao {
    @Query("SELECT * FROM FlashCardEntity")
    suspend fun getAll(): List<FlashCardEntity>

    @Query("SELECT * FROM FlashCardEntity")
    fun getFlashCardPaged(): DataSource.Factory<Int, FlashCardEntity>

    @Insert
    suspend fun insertAll(vararg card: FlashCardEntity)

    @Query("DELETE FROM FlashCardEntity WHERE `id` = :id")
    fun delete(id: Int)

    @Query("UPDATE FlashCardEntity SET `correctCount` = `correctCount` + 1 WHERE `id` = :id")
    fun incrementCorrect(id: Int)

    @Query("UPDATE FlashCardEntity SET `incorrectCount` = `incorrectCount` + 1 WHERE `id` = :id")
    fun incrementIncorrect(id: Int)
}
