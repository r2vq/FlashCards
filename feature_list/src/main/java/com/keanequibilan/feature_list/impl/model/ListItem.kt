package com.keanequibilan.feature_list.impl.model

import com.keanequibilan.feature_list.impl.model.ListItemType.CARD_LIST_ITEM
import com.keanequibilan.feature_list.impl.model.ListItemType.DANGER_LIST_ITEM
import com.keanequibilan.feature_list.impl.model.ListItemType.NEUTRAL_LIST_ITEM

internal enum class ListItemType(val value: Int) {
    UNKNOWN(-1),
    CARD_LIST_ITEM(0),
    NEUTRAL_LIST_ITEM(1),
    DANGER_LIST_ITEM(2);

    companion object {
        fun enumFor(value: Int): ListItemType = values()
            .firstOrNull { it.value == value }
            ?: UNKNOWN
    }
}

internal sealed class ListItem(
    type: ListItemType
) {
    abstract val id: Int
    val type: Int = type.value
}

internal data class CardListItem(
    override val id: Int,
    val name: String,
    val back: String,
    val correct: Int,
    val incorrect: Int
) : ListItem(
    when {
        correct < incorrect -> DANGER_LIST_ITEM
        correct == 0 -> NEUTRAL_LIST_ITEM
        else -> CARD_LIST_ITEM
    }
)
