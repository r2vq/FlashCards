package com.keanequibilan.flashcards.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.keanequibilan.viewmodel.model.ListItem

object ListItemDiffUtil : DiffUtil.ItemCallback<ListItem>() {
    override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean =
        oldItem == newItem
}
