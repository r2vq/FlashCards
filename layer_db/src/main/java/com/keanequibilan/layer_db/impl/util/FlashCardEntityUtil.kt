package com.keanequibilan.layer_db.impl.util

import com.keanequibilan.layer_db.impl.entity.FlashCardEntity
import com.keanequibilan.layer_db.model.DbCard

internal fun FlashCardEntity.toDbCard(): DbCard = DbCard(
    id = id,
    front = front,
    back = back
)
