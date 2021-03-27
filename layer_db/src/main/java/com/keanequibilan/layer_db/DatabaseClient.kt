package com.keanequibilan.layer_db

import androidx.paging.DataSource
import com.keanequibilan.layer_db.model.DbCard
import com.keanequibilan.layer_db.model.DbCardSession
import com.keanequibilan.layer_db.model.DbCurrentCardSession
import com.keanequibilan.layer_db.model.DbSession

interface DatabaseClient {
    suspend fun createCard(front: String, back: String)
    suspend fun createCardSession(
        cardId: Int,
        sessionId: Int,
        correct: Int,
        incorrect: Int,
        skip: Int
    )

    suspend fun createSession()

    suspend fun getAllCards(): List<DbCard>
    suspend fun getCard(id: Int): DbCard?
    suspend fun getCardSession(cardId: Int, sessionId: Int): DbCardSession?
    fun getCurrentCardSessions(): DataSource.Factory<Int, DbCurrentCardSession>
    suspend fun getCurrentSession(): DbSession
    suspend fun getSessionsForCard(cardId: Int): List<DbCardSession>

    suspend fun updateCardSession(
        cardId: Int,
        sessionId: Int,
        correct: Int,
        incorrect: Int,
        skip: Int
    )

    suspend fun deleteCard(id: Int)
}
