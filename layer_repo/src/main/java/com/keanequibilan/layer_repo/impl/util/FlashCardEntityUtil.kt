package com.keanequibilan.layer_repo.impl.util

import com.keanequibilan.layer_db.model.DbCard
import com.keanequibilan.layer_db.model.DbCardDetails
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

internal fun DbCardDetails.toLocalDetails() = LocalCardDetails(
    id = card.id,
    front = card.front,
    back = card.back,
    sessions = sessions.map(DbCardSession::toDetailsSession)
)

internal fun DbCardSession.toDetailsSession(): DetailsSession = DetailsSession(
    id = sessionId,
    correct = correct,
    incorrect = incorrect,
    skips = skip
)
