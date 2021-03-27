package com.keanequibilan.layer_repo.impl.util

import com.keanequibilan.layer_db.model.DbCard
import com.keanequibilan.layer_db.model.DbCardSession
import com.keanequibilan.layer_repo.model.DetailsSession
import com.keanequibilan.layer_repo.model.LocalCardDetails
import com.keanequibilan.layer_repo.model.LocalSwipeCard

internal fun DbCard?.toLocalFlashCard() = this
    ?.id
    ?.let {
        LocalSwipeCard(
            id = it,
            front = front,
            back = back
        )
    }

internal fun toLocalDetails(
    card: DbCard?,
    sessions: List<DbCardSession>
): LocalCardDetails? = card?.run {
    LocalCardDetails(
        id = id,
        front = front,
        back = back,
        sessions = toDetailsSession(sessions)
    )
}

private fun toDetailsSession(
    sessions: List<DbCardSession>
): List<DetailsSession> = sessions.map { session ->
    DetailsSession(
        id = session.sessionId,
        correct = session.correct,
        incorrect = session.incorrect,
        skips = session.skip
    )
}
