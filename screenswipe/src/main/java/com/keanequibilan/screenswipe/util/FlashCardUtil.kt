package com.keanequibilan.screenswipe.util

import com.keanequibilan.repository.model.LocalSwipeCard
import com.keanequibilan.screenswipe.model.CardItem

internal fun LocalSwipeCard.toCardItem(): CardItem = CardItem(
    id = id,
    message = front,
    otherMessage = back
)
