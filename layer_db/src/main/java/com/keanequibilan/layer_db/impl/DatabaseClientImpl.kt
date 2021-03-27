package com.keanequibilan.layer_db.impl

import com.keanequibilan.layer_db.DatabaseClient
import com.keanequibilan.layer_db.impl.db.FlashCardDatabase
import com.keanequibilan.layer_db.impl.entity.CardSessionEntity
import com.keanequibilan.layer_db.impl.entity.CardSessionView
import com.keanequibilan.layer_db.impl.entity.FlashCardEntity
import com.keanequibilan.layer_db.impl.entity.SessionEntity
import com.keanequibilan.layer_db.impl.util.toDbCard
import com.keanequibilan.layer_db.impl.util.toDbCardSession
import com.keanequibilan.layer_db.impl.util.toDbSession
import com.keanequibilan.layer_db.model.DbSession

internal class DatabaseClientImpl(
    private val db: FlashCardDatabase
) : DatabaseClient {
    override suspend fun createCard(front: String, back: String) = db
        .flashCardDao()
        .insertAll(
            FlashCardEntity(
                front = front,
                back = back
            )
        )

    override suspend fun createCardSession(
        cardId: Int,
        sessionId: Int,
        correct: Int,
        incorrect: Int,
        skip: Int
    ) = db
        .cardSessionDao()
        .insertAll(
            CardSessionEntity(
                cardId = cardId,
                sessionId = sessionId,
                correct = correct,
                incorrect = incorrect,
                skip = skip
            )
        )

    override suspend fun createSession() = db
        .sessionDao()
        .insertAll(SessionEntity())

    override suspend fun getAllCards() = db
        .flashCardDao()
        .getAll()
        .map(FlashCardEntity::toDbCard)

    override suspend fun getCurrentSession(): DbSession = db
        .sessionDao()
        .run {
            getCurrentSession()
                ?: (SessionEntity(1).also { insertAll(it) })
        }
        .let(SessionEntity::toDbSession)

    override suspend fun getCard(id: Int) = db
        .flashCardDao()
        .get(id)
        ?.toDbCard()

    override suspend fun getSessionsForCard(cardId: Int) = db
        .cardSessionDao()
        .getSessionsForCard(cardId)
        .map(CardSessionEntity::toDbCardSession)

    override fun getCurrentCardSessions() = db
        .cardSessionViewDao()
        .getFlashCardPaged()
        .map(CardSessionView::toDbCardSession)

    override suspend fun getCardSession(cardId: Int, sessionId: Int) = db
        .cardSessionDao()
        .getCardSession(cardId, sessionId)
        ?.let(CardSessionEntity::toDbCardSession)

    override suspend fun updateCardSession(
        cardId: Int,
        sessionId: Int,
        correct: Int,
        incorrect: Int,
        skip: Int
    ) = db
        .cardSessionDao()
        .update(
            CardSessionEntity(
                cardId = cardId,
                sessionId = sessionId,
                correct = correct,
                incorrect = incorrect,
                skip = skip
            )
        )

    override suspend fun deleteCard(id: Int) = db
        .flashCardDao()
        .delete(id)
}
