package com.keanequibilan.screenlist.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.keanequibilan.screenlist.model.DetailItem

internal object DetailItemDiffUtil : DiffUtil.ItemCallback<DetailItem>() {
    override fun areItemsTheSame(oldItem: DetailItem, newItem: DetailItem): Boolean =
        oldItem.type == newItem.type && oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: DetailItem, newItem: DetailItem): Boolean =
        oldItem == newItem
}
