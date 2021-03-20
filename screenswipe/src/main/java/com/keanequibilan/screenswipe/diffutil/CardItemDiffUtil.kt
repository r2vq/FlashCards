package com.keanequibilan.screenswipe.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.keanequibilan.screenswipe.model.CardItem

internal object CardItemDiffUtil : DiffUtil.ItemCallback<CardItem>() {
    override fun areItemsTheSame(oldItem: CardItem, newItem: CardItem): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: CardItem, newItem: CardItem): Boolean =
        oldItem == newItem
}
