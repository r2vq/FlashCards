package com.keanequibilan.repository.util

import com.keanequibilan.database.entity.CardSessionEntity
import com.keanequibilan.database.entity.FlashCardEntity
import com.keanequibilan.repository.model.DetailsSession
import com.keanequibilan.repository.model.LocalCardDetails
import com.keanequibilan.repository.model.LocalSwipeCard

internal fun FlashCardEntity?.toLocalFlashCard() = this
    ?.id
    ?.let {
        LocalSwipeCard(
            id = it,
            front = front,
            back = back
        )
    }

internal fun toLocalDetails(
    card: FlashCardEntity?,
    sessions: List<CardSessionEntity>
): LocalCardDetails? = card?.run {
    LocalCardDetails(
        id = id,
        front = front,
        back = back,
        sessions = toDetailsSession(sessions)
    )
}

private fun toDetailsSession(
    sessions: List<CardSessionEntity>
): List<DetailsSession> = sessions.map { session ->
    DetailsSession(
        id = session.sessionId,
        correct = session.correct,
        incorrect = session.incorrect,
        skips = session.skip
    )
}
