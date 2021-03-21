package com.keanequibilan.screenlist.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.keanequibilan.screenlist.diffutil.ListItemDiffUtil
import com.keanequibilan.common.util.inflateChild
import com.keanequibilan.screenlist.R
import com.keanequibilan.screenlist.model.ListItem
import com.keanequibilan.screenlist.model.ListItemType
import com.keanequibilan.screenlist.viewholder.CardListItemViewHolder
import com.keanequibilan.screenlist.viewholder.ItemViewHolder

internal class CardAdapter : PagedListAdapter<ListItem, ItemViewHolder>(ListItemDiffUtil) {
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
