package com.keanequibilan.database.impl.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.keanequibilan.database.impl.entity.CardSessionEntity

@Dao
internal interface CardSessionDao {
    @Query("SELECT * FROM CardSessionEntity WHERE `cardId` = :cardId AND `sessionId` = :sessionId")
    suspend fun getCardSession(cardId: Int, sessionId: Int): CardSessionEntity?

    @Query("SELECT * FROM CardSessionEntity WHERE `cardId` = :cardId")
    suspend fun getSessionsForCard(cardId: Int): List<CardSessionEntity>

    @Insert
    suspend fun insertAll(vararg cardSession: CardSessionEntity)

    @Update
    suspend fun update(cardSession: CardSessionEntity)
}
