package com.keanequibilan.screenlist.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.keanequibilan.common.util.inflateChild
import com.keanequibilan.screenlist.R
import com.keanequibilan.screenlist.diffutil.ListItemDiffUtil
import com.keanequibilan.screenlist.model.CardListItem
import com.keanequibilan.screenlist.model.ListItem
import com.keanequibilan.screenlist.model.ListItemType
import com.keanequibilan.screenlist.viewholder.CardListItemViewHolder
import com.keanequibilan.screenlist.viewholder.ItemViewHolder

internal class CardAdapter : PagedListAdapter<ListItem, ItemViewHolder>(ListItemDiffUtil) {
    private var onItemClickListener: ((item: CardListItem) -> Unit)? = null
    private var onItemLongPressListener: ((item: CardListItem) -> Unit)? = null

    override fun getItemViewType(position: Int): Int =
        getItem(position)?.type ?: ListItemType.unknown

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        when (viewType) {
            ListItemType.cardListItem -> CardListItemViewHolder(
                itemView = parent.inflateChild(R.layout.list_item),
                onClick = { item -> onItemClickListener?.invoke(item) },
                onLongPress = { item -> onItemLongPressListener?.invoke(item) }
            )
            ListItemType.unknown -> throw IllegalArgumentException("Unknown card type")
            else -> throw IllegalArgumentException("Unmatched card type")
        }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun setOnItemClickListener(callback: ((id: CardListItem) -> Unit)?) {
        onItemClickListener = callback
    }

    fun setOnItemLongPressListener(callback: ((id: CardListItem) -> Unit)?) {
        onItemLongPressListener = callback
    }
}
