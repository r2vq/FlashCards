package com.keanequibilan.database.impl.util

import com.keanequibilan.database.impl.entity.CardSessionView
import com.keanequibilan.database.model.DbCurrentCardSession

internal fun CardSessionView.toDbCardSession(): DbCurrentCardSession = DbCurrentCardSession(
    id = id,
    sessionId = sessionId,
    front = front,
    back = back,
    correct = correct,
    incorrect = incorrect,
    skip = skip
)
