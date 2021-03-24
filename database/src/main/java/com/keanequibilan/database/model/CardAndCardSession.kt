package com.keanequibilan.database.model

import androidx.room.Embedded
import com.keanequibilan.database.entity.CardSessionEntity
import com.keanequibilan.database.entity.FlashCardEntity

data class CardAndCardSession(
    @Embedded val card: FlashCardEntity,
    @Embedded val session: CardSessionEntity
)
