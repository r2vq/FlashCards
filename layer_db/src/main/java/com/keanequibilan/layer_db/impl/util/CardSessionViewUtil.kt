package com.keanequibilan.layer_db.impl.util

import com.keanequibilan.layer_db.impl.entity.CardSessionView
import com.keanequibilan.layer_db.model.DbCurrentCardSession

internal fun CardSessionView.toDbCardSession(): DbCurrentCardSession = DbCurrentCardSession(
    cardId = id,
    sessionId = sessionId,
    front = front,
    back = back,
    correct = correct,
    incorrect = incorrect,
    skip = skip
)
