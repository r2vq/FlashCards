package com.keanequibilan.screenswipe.model

import com.keanequibilan.screenswipe.model.CardItemType.BACK
import com.keanequibilan.screenswipe.model.CardItemType.FRONT
import kotlin.reflect.KProperty

internal enum class CardItemType(val intValue: Int) {
    UNKNOWN(-1),
    FRONT(0),
    BACK(1)
}

internal sealed class CardItem(
    type: CardItemType
) {
    abstract val id: Int
    val type: Int = type.intValue
}

internal data class FrontCardItem(
    override val id: Int,
    val message: String
) : CardItem(
    FRONT
)

internal data class BackCardItem(
    override val id: Int,
    val message: String
) : CardItem(
    BACK
)
