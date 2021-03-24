package com.keanequibilan.screenswipe.util

import com.keanequibilan.repository.model.LocalFlashCard
import com.keanequibilan.screenswipe.model.CardItem

internal fun LocalFlashCard.toCardItem(): CardItem = CardItem(
    id = id,
    message = front,
    otherMessage = back
)
