package com.keanequibilan.repository.util

import com.keanequibilan.database.entity.CardSessionView
import com.keanequibilan.repository.model.LocalFlashCard

internal fun CardSessionView?.toLocalFlashCard() = this
    ?.let {
        LocalFlashCard(
            id = id,
            front = front,
            back = back,
            correct = correct,
            incorrect = incorrect
        )
    }
