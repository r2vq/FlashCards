package com.keanequibilan.screenswipe.util

import com.keanequibilan.repository.model.LocalFlashCard
import com.keanequibilan.screenswipe.model.CardItem
import com.keanequibilan.screenswipe.model.FrontCardItem

internal fun LocalFlashCard.toCardItem(): CardItem = FrontCardItem(
    id = id,
    message = front
)
