package com.keanequibilan.database.impl.util

import com.keanequibilan.database.impl.entity.FlashCardEntity
import com.keanequibilan.database.model.DbCard

internal fun FlashCardEntity.toDbCard(): DbCard = DbCard(
    id = id,
    front = front,
    back = back
)
