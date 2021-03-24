package com.keanequibilan.screenswipe.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.keanequibilan.common.util.inflateChild
import com.keanequibilan.screenswipe.R
import com.keanequibilan.screenswipe.diffutil.CardItemDiffUtil
import com.keanequibilan.screenswipe.model.CardItem
import com.keanequibilan.screenswipe.viewholder.CardItemViewHolder

internal class CardAdapter : ListAdapter<CardItem, CardItemViewHolder>(CardItemDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardItemViewHolder =
        CardItemViewHolder(parent.inflateChild(R.layout.card_item_front))

    override fun onBindViewHolder(holder: CardItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
