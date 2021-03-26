package com.keanequibilan.repository.impl

import androidx.paging.DataSource
import com.keanequibilan.database.DatabaseClient
import com.keanequibilan.database.model.DbCard
import com.keanequibilan.database.model.DbCurrentCardSession
import com.keanequibilan.repository.Repository
import com.keanequibilan.repository.impl.util.toLocalDetails
import com.keanequibilan.repository.impl.util.toLocalFlashCard
import com.keanequibilan.repository.model.LocalCardDetails
import com.keanequibilan.repository.model.LocalFlashCard
import com.keanequibilan.repository.model.LocalSwipeCard

internal class RepositoryImpl(
    private val db: DatabaseClient
) : Repository {
    override suspend fun getCards(): List<LocalSwipeCard> = db
        .getAllCards()
        .mapNotNull(DbCard?::toLocalFlashCard)

    override suspend fun getCardDetails(id: Int): LocalCardDetails? {
        val card = db
            .getCard(id)

        val sessions = db
            .getSessionsForCard(id)

        return toLocalDetails(card, sessions)
    }

    override fun getCardsPaged(): DataSource.Factory<Int, LocalFlashCard> = db
        .getCurrentCardSessions()
        .map(DbCurrentCardSession?::toLocalFlashCard)

    override suspend fun createCard(front: String, back: String) = db
        .createCard(
            front = front,
            back = back
        )

    override suspend fun deleteCard(id: Int) = db
        .deleteCard(id)

    override suspend fun createSession() = db
        .createSession()

    override suspend fun updateCardSession(
        cardId: Int,
        correct: Int,
        incorrect: Int,
        skip: Int
    ) {
        val currentSessionId = db.getCurrentSession().id
        val cardSession = db.getCardSession(cardId, currentSessionId)

        cardSession
            ?.let {
                db.updateCardSession(
                    cardId = cardId,
                    sessionId = currentSessionId,
                    correct = cardSession.correct + correct,
                    incorrect = cardSession.incorrect + incorrect,
                    skip = cardSession.skip + skip
                )
            }
            ?: run {
                db.createCardSession(
                    cardId = cardId,
                    sessionId = currentSessionId,
                    correct = correct,
                    incorrect = incorrect,
                    skip = skip
                )
            }

    }
}
