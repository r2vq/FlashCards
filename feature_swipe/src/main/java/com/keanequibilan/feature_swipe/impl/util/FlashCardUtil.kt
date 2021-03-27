package com.keanequibilan.feature_swipe.impl.util

import com.keanequibilan.feature_swipe.impl.model.CardItem
import com.keanequibilan.layer_repo.model.LocalSwipeCard

internal fun LocalSwipeCard.toCardItem(): CardItem = CardItem(
    id = id,
    message = front,
    otherMessage = back
)
