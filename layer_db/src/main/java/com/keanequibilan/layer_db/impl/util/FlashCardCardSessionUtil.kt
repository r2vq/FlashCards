package com.keanequibilan.layer_db.impl.util

import com.keanequibilan.layer_db.impl.entity.CardSessionEntity
import com.keanequibilan.layer_db.impl.entity.FlashCardCardSession
import com.keanequibilan.layer_db.model.DbCardDetails

internal fun FlashCardCardSession.toDbCardDetails(): DbCardDetails = DbCardDetails(
    card = card.toDbCard(),
    sessions = sessions.map(CardSessionEntity::toDbCardSession)
)
