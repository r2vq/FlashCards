package com.keanequibilan.flashcards.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.keanequibilan.flashcards.R
import com.keanequibilan.flashcards.diffutil.ListItemDiffUtil
import com.keanequibilan.flashcards.util.inflateChild
import com.keanequibilan.flashcards.viewholder.CardListItemViewHolder
import com.keanequibilan.flashcards.viewholder.ItemViewHolder
import com.keanequibilan.viewmodel.model.ListItem
import com.keanequibilan.viewmodel.model.ListItemType

class CardAdapter : PagedListAdapter<ListItem, ItemViewHolder>(ListItemDiffUtil) {
    override fun getItemViewType(position: Int): Int =
        getItem(position)?.type ?: ListItemType.unknown

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        when (viewType) {
            ListItemType.cardListItem -> CardListItemViewHolder(
                parent.inflateChild(R.layout.list_item_card)
            )
            ListItemType.unknown -> throw IllegalArgumentException("Unknown card type")
            else -> throw IllegalArgumentException("Unmatched card type")
        }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
