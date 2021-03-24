package com.keanequibilan.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.keanequibilan.database.entity.CardSessionEntity

@Dao
interface CardSessionDao {
    @Query("SELECT * FROM CardSessionEntity WHERE `cardId` = :cardId AND `sessionId` = :sessionId")
    suspend fun getCardSession(cardId: Int, sessionId: Int): CardSessionEntity?

    @Insert
    suspend fun insertAll(vararg cardSession: CardSessionEntity)

    @Update
    suspend fun update(cardSession: CardSessionEntity)
}
