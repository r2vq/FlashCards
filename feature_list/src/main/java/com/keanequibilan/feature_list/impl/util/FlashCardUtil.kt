package com.keanequibilan.feature_list.impl.util

import com.keanequibilan.feature_list.impl.model.CardListItem
import com.keanequibilan.feature_list.impl.model.ListItem
import com.keanequibilan.layer_repo.model.LocalFlashCard

internal fun LocalFlashCard.toListItem(): ListItem = CardListItem(
    id = id,
    name = front,
    back = back,
    correct = correct,
    incorrect = incorrect
)
