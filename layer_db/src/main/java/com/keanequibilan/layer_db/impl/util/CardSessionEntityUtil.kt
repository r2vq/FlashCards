package com.keanequibilan.layer_db.impl.util

import com.keanequibilan.layer_db.impl.entity.CardSessionEntity
import com.keanequibilan.layer_db.model.DbCardSession

internal fun CardSessionEntity.toDbCardSession() = DbCardSession(
    cardId = cardId,
    sessionId = sessionId,
    correct = correct,
    incorrect = incorrect,
    skip = skip
)
