package com.keanequibilan.repository.util

import com.keanequibilan.database.entity.FlashCardEntity
import com.keanequibilan.repository.model.LocalSwipeCard

internal fun FlashCardEntity?.toLocalFlashCard() = this
    ?.id
    ?.let {
        LocalSwipeCard(
            id = it,
            front = front,
            back = back
        )
    }
