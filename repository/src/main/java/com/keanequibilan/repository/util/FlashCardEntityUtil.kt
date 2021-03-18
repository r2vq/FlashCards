package com.keanequibilan.repository.util

import com.keanequibilan.database.entity.FlashCardEntity
import com.keanequibilan.repository.model.LocalFlashCard

fun FlashCardEntity?.toLocalFlashCard() = this
    ?.id
    ?.let {
        LocalFlashCard(
            id = it,
            name = name
        )
    }
