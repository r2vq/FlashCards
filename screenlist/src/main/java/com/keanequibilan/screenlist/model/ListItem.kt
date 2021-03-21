package com.keanequibilan.screenlist.model

import com.keanequibilan.screenlist.model.ListItemType.CARD_LIST_ITEM
import com.keanequibilan.screenlist.model.ListItemType.DANGER_LIST_ITEM

internal enum class ListItemType(val value: Int) {
    UNKNOWN(-1),
    CARD_LIST_ITEM(0),
    DANGER_LIST_ITEM(1);

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
    val correct: Int,
    val incorrect: Int
) : ListItem(if (correct < incorrect) DANGER_LIST_ITEM else CARD_LIST_ITEM)
