package com.keanequibilan.screenlist.model

internal abstract class DetailItem {
    abstract val type: Int
    abstract val id: Int
    abstract override fun equals(other: Any?): Boolean
    abstract override fun hashCode(): Int

    object Types {
        const val DETAIL_CARD_ITEM = 0
        const val DETAIL_SESSION_ITEM = 1
    }
}

internal data class DetailCardItem(
    override val id: Int,
    val front: String,
    val back: String
) : DetailItem() {
    override val type: Int = Types.DETAIL_CARD_ITEM
}

internal data class DetailSessionItem(
    override val id: Int,
    val correct: Int,
    val incorrect: Int,
    val skips: Int
) : DetailItem() {
    override val type: Int = Types.DETAIL_SESSION_ITEM
}
