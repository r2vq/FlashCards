package com.keanequibilan.layer_db.impl.entity

import androidx.room.Embedded
import androidx.room.Relation

internal data class FlashCardCardSession(
    @Embedded
    val card: FlashCardEntity,

    @Relation(parentColumn = "id", entityColumn = "cardId")
    val sessions: List<CardSessionEntity>
)
