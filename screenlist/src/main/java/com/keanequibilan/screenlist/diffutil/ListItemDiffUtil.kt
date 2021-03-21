package com.keanequibilan.screenlist.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.keanequibilan.screenlist.model.ListItem

internal object ListItemDiffUtil : DiffUtil.ItemCallback<ListItem>() {
    override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean =
        oldItem == newItem
}
