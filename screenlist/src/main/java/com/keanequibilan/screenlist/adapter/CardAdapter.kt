package com.keanequibilan.screenlist.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.keanequibilan.common.util.inflateChild
import com.keanequibilan.screenlist.R
import com.keanequibilan.screenlist.diffutil.ListItemDiffUtil
import com.keanequibilan.screenlist.model.CardListItem
import com.keanequibilan.screenlist.model.ListItem
import com.keanequibilan.screenlist.model.ListItemType
import com.keanequibilan.screenlist.model.ListItemType.CARD_LIST_ITEM
import com.keanequibilan.screenlist.model.ListItemType.DANGER_LIST_ITEM
import com.keanequibilan.screenlist.model.ListItemType.NEUTRAL_LIST_ITEM
import com.keanequibilan.screenlist.model.ListItemType.UNKNOWN
import com.keanequibilan.screenlist.viewholder.CardListItemViewHolder
import com.keanequibilan.screenlist.viewholder.CardListItemViewHolder.ViewHolderType.BAD
import com.keanequibilan.screenlist.viewholder.CardListItemViewHolder.ViewHolderType.GOOD
import com.keanequibilan.screenlist.viewholder.CardListItemViewHolder.ViewHolderType.NEUTRAL
import com.keanequibilan.screenlist.viewholder.ItemViewHolder

internal class CardAdapter : PagedListAdapter<ListItem, ItemViewHolder>(ListItemDiffUtil) {
    private var onItemClickListener: ((item: CardListItem) -> Unit)? = null
    private var onItemLongPressListener: ((item: CardListItem) -> Unit)? = null

    override fun getItemViewType(position: Int): Int =
        getItem(position)?.type ?: UNKNOWN.value

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CardListItemViewHolder(
        itemView = parent.inflateChild(R.layout.list_item),
        onClick = { item -> onItemClickListener?.invoke(item) },
        onLongPress = { item -> onItemLongPressListener?.invoke(item) },
        type = when (ListItemType.enumFor(viewType)) {
            CARD_LIST_ITEM -> GOOD
            NEUTRAL_LIST_ITEM -> NEUTRAL
            DANGER_LIST_ITEM -> BAD
            else -> throw IllegalArgumentException("Unmatched card type")
        }
    )

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
