package com.keanequibilan.screenlist.model

internal object ListItemType {
    const val unknown = -1
    const val cardListItem = 0
}

internal sealed class ListItem {
    abstract val id: Int
    abstract val type: Int
}

internal data class CardListItem(
    override val id: Int,
    val name: String
) : ListItem() {
    override val type = ListItemType.cardListItem
}

