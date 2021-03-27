package com.keanequibilan.feature_swipe.impl.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.keanequibilan.feature_swipe.impl.model.CardItem

internal object CardItemDiffUtil : DiffUtil.ItemCallback<CardItem>() {
    override fun areItemsTheSame(oldItem: CardItem, newItem: CardItem): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: CardItem, newItem: CardItem): Boolean =
        oldItem == newItem
}
