package com.keanequibilan.screenlist.util

import com.keanequibilan.repository.model.LocalFlashCard
import com.keanequibilan.screenlist.model.CardListItem
import com.keanequibilan.screenlist.model.ListItem

internal fun LocalFlashCard.toListItem(): ListItem = CardListItem(
    id = id,
    name = front,
    back = back,
    correct = correct,
    incorrect = incorrect
)
