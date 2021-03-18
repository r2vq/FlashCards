package com.keanequibilan.viewmodel.util

import com.keanequibilan.repository.model.LocalFlashCard
import com.keanequibilan.viewmodel.model.CardListItem
import com.keanequibilan.viewmodel.model.ListItem

fun LocalFlashCard.toListItem(): ListItem = CardListItem(
    id = id,
    name = name
)
