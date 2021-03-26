package com.keanequibilan.database.impl.entity

import androidx.room.Entity

@Entity(
    primaryKeys = [
        "cardId",
        "sessionId"
    ]
)
internal data class CardSessionEntity(
    val cardId: Int,
    val sessionId: Int,
    val correct: Int,
    val incorrect: Int,
    val skip: Int
)
