package com.keanequibilan.feature_swipe.impl.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.keanequibilan.common.util.inflateChild
import com.keanequibilan.feature_swipe.R
import com.keanequibilan.feature_swipe.impl.diffutil.CardItemDiffUtil
import com.keanequibilan.feature_swipe.impl.model.CardItem
import com.keanequibilan.feature_swipe.impl.viewholder.CardItemViewHolder

internal class CardAdapter : ListAdapter<CardItem, CardItemViewHolder>(CardItemDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardItemViewHolder =
        CardItemViewHolder(parent.inflateChild(R.layout.card_item_front))

    override fun onBindViewHolder(holder: CardItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
