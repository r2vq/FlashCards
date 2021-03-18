package com.keanequibilan.viewmodel.model

object ListItemType {
    const val cardListItem = 0
}

sealed class ListItem {
    abstract val id: Int
    abstract val type: Int
}

data class CardListItem(
    override val id: Int,
    val name: String
) : ListItem() {
    override val type = ListItemType.cardListItem
}
