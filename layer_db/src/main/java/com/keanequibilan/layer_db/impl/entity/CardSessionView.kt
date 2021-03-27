package com.keanequibilan.layer_db.impl.entity

import androidx.room.DatabaseView

@DatabaseView(
    "SELECT id, IfNull(sessionId, (SELECT MAX(id) FROM SessionEntity)) AS sessionId, front, back, IfNull(correct, 0) AS correct, IfNull(incorrect, 0) AS incorrect, IfNull(skip, 0) AS skip FROM FlashCardEntity LEFT JOIN (SELECT * FROM CardSessionEntity WHERE sessionId = (SELECT MAX(id) FROM SessionEntity)) AS CardSession ON id = cardId"
)
internal data class CardSessionView(
    val id: Int,
    val sessionId: Int,
    val front: String,
    val back: String,
    val correct: Int,
    val incorrect: Int,
    val skip: Int
)
