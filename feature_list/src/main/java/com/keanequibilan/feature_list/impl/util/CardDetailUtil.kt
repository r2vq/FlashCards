package com.keanequibilan.feature_list.impl.util

import com.keanequibilan.feature_list.impl.model.DetailCardItem
import com.keanequibilan.feature_list.impl.model.DetailItem
import com.keanequibilan.feature_list.impl.model.DetailSessionItem
import com.keanequibilan.layer_repo.model.LocalCardDetails

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
