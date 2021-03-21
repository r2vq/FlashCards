package com.keanequibilan.repository.util

import com.keanequibilan.database.entity.FlashCardEntity
import com.keanequibilan.repository.model.LocalFlashCard

internal fun FlashCardEntity?.toLocalFlashCard() = this
    ?.id
    ?.let {
        LocalFlashCard(
            id = it,
            front = front,
            back = back,
            correct = correctCount,
            incorrect = incorrectCount
        )
    }
