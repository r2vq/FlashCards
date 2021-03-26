package com.keanequibilan.database.impl.util

import com.keanequibilan.database.impl.entity.CardSessionEntity
import com.keanequibilan.database.model.DbCardSession

internal fun CardSessionEntity.toDbCardSession() = DbCardSession(
    cardId = cardId,
    sessionId = sessionId,
    correct = correct,
    incorrect = incorrect,
    skip = skip
)
