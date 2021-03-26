package com.keanequibilan.repository.util

import com.keanequibilan.database.model.DbCurrentCardSession
import com.keanequibilan.repository.model.LocalFlashCard

internal fun DbCurrentCardSession?.toLocalFlashCard() = this
    ?.let {
        LocalFlashCard(
            id = id,
            front = front,
            back = back,
            correct = correct,
            incorrect = incorrect
        )
    }
