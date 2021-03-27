package com.keanequibilan.layer_repo.impl.util

import com.keanequibilan.database.model.DbCurrentCardSession
import com.keanequibilan.layer_repo.model.LocalFlashCard

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
