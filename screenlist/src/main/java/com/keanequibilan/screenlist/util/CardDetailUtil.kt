package com.keanequibilan.screenlist.util

import com.keanequibilan.repository.model.LocalCardDetails
import com.keanequibilan.screenlist.model.DetailCardItem
import com.keanequibilan.screenlist.model.DetailItem
import com.keanequibilan.screenlist.model.DetailSessionItem

internal fun LocalCardDetails?.toDetailItems(): List<DetailItem> {
    val detailCardItem = this?.run {
        listOf<DetailItem>(
            DetailCardItem(
                id = id,
                front = front,
                back = back
            )
        )
    } ?: emptyList()

    val detailSessions = this?.sessions?.map { session ->
        DetailSessionItem(
            id = session.id,
            correct = session.correct,
            incorrect = session.incorrect,
            skips = session.skips
        )
    } ?: emptyList()

    return detailCardItem.plus(detailSessions)
}
