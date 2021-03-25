package com.keanequibilan.repository.impl

import androidx.paging.DataSource
import com.keanequibilan.database.FlashCardDatabase
import com.keanequibilan.database.entity.CardSessionEntity
import com.keanequibilan.database.entity.CardSessionView
import com.keanequibilan.database.entity.FlashCardEntity
import com.keanequibilan.database.entity.SessionEntity
import com.keanequibilan.repository.Repository
import com.keanequibilan.repository.model.LocalCardDetails
import com.keanequibilan.repository.model.LocalFlashCard
import com.keanequibilan.repository.model.LocalSwipeCard
import com.keanequibilan.repository.util.toLocalDetails
import com.keanequibilan.repository.util.toLocalFlashCard

internal class RepositoryImpl(
    private val db: FlashCardDatabase
) : Repository {
    override suspend fun getCards(): List<LocalSwipeCard> = db
        .flashCardDao()
        .getAll()
        .mapNotNull(FlashCardEntity?::toLocalFlashCard)

    override suspend fun getCardDetails(cardId: Int): LocalCardDetails? {
        val card = db
            .flashCardDao()
            .get(cardId)

        val sessions = db
            .cardSessionDao()
            .getSessionsForCard(cardId)

        return toLocalDetails(card, sessions)
    }

    override fun getCardsPaged(): DataSource.Factory<Int, LocalFlashCard> = db
        .cardSessionViewDao()
        .getFlashCardPaged()
        .map(CardSessionView?::toLocalFlashCard)

    override suspend fun createCard(front: String, back: String) = db
        .flashCardDao()
        .insertAll(
            FlashCardEntity(
                front = front,
                back = back
            )
        )

    override suspend fun deleteCard(id: Int) = db
        .flashCardDao()
        .delete(id)

    override suspend fun createSession() = db
        .sessionDao()
        .insertAll(SessionEntity())

    override suspend fun updateCardSession(
        cardId: Int,
        correct: Int,
        incorrect: Int,
        skip: Int
    ) {
        val currentSessionId = getCurrentSession().id
        val dao = db.cardSessionDao()
        val cardSession = dao.getCardSession(cardId, currentSessionId)

        cardSession
            ?.let {
                dao
                    .update(
                        CardSessionEntity(
                            cardId = cardId,
                            sessionId = currentSessionId,
                            correct = cardSession.correct + correct,
                            incorrect = cardSession.incorrect + incorrect,
                            skip = cardSession.skip + skip
                        )
                    )
            }
            ?: run {
                dao
                    .insertAll(
                        CardSessionEntity(
                            cardId = cardId,
                            sessionId = currentSessionId,
                            correct = correct,
                            incorrect = incorrect,
                            skip = skip
                        )
                    )
            }

    }

    private suspend fun getCurrentSession(): SessionEntity = db
        .sessionDao()
        .run {
            getCurrentSession()
                ?: (SessionEntity(1).also { insertAll(it) })
        }
}
