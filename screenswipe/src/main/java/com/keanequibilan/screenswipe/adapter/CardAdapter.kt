package com.keanequibilan.screenswipe.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.keanequibilan.common.util.inflateChild
import com.keanequibilan.screenswipe.R
import com.keanequibilan.screenswipe.diffutil.CardItemDiffUtil
import com.keanequibilan.screenswipe.model.CardItem
import com.keanequibilan.screenswipe.model.CardItemType.BACK
import com.keanequibilan.screenswipe.model.CardItemType.FRONT
import com.keanequibilan.screenswipe.model.CardItemType.UNKNOWN
import com.keanequibilan.screenswipe.viewholder.BackCardItemViewHolder
import com.keanequibilan.screenswipe.viewholder.CardItemViewHolder
import com.keanequibilan.screenswipe.viewholder.FrontCardItemViewHolder
import com.keanequibilan.screenswipe.viewholder.UnknownViewHolder

internal class CardAdapter : ListAdapter<CardItem, CardItemViewHolder>(CardItemDiffUtil) {
    override fun getItemViewType(position: Int): Int = getItem(position)?.type ?: UNKNOWN.intValue

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardItemViewHolder =
        when (viewType) {
            FRONT.intValue -> FrontCardItemViewHolder(parent.inflateChild(R.layout.card_item_front))
            BACK.intValue -> BackCardItemViewHolder(parent.inflateChild(R.layout.card_item_back))
            else -> UnknownViewHolder(parent.inflateChild(R.layout.card_item_front))
        }

    override fun onBindViewHolder(holder: CardItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
