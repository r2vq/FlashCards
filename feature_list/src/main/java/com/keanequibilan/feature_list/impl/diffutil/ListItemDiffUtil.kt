package com.keanequibilan.feature_list.impl.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.keanequibilan.feature_list.impl.model.ListItem

internal object ListItemDiffUtil : DiffUtil.ItemCallback<ListItem>() {
    override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean =
        oldItem == newItem
}
