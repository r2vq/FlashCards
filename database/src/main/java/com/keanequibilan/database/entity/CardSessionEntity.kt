package com.keanequibilan.database.entity

import androidx.room.Entity

@Entity(
    primaryKeys = [
        "cardId",
        "sessionId"
    ]
)
data class CardSessionEntity(
    val cardId: Int,
    val sessionId: Int,
    val correct: Int,
    val incorrect: Int,
    val skip: Int
)
