package com.keanequibilan.screenlist.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.keanequibilan.common.util.inflateChild
import com.keanequibilan.screenlist.R
import com.keanequibilan.screenlist.diffutil.DetailItemDiffUtil
import com.keanequibilan.screenlist.model.DetailItem
import com.keanequibilan.screenlist.viewholder.DetailCardViewHolder
import com.keanequibilan.screenlist.viewholder.DetailSessionViewHolder
import com.keanequibilan.screenlist.viewholder.DetailViewHolder

internal class DetailsAdapter : ListAdapter<DetailItem, DetailViewHolder>(DetailItemDiffUtil) {
    override fun getItemViewType(position: Int): Int = getItem(position).type

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder =
        when (viewType) {
            DetailItem.Types.DETAIL_CARD_ITEM -> {
                DetailCardViewHolder(
                    parent.inflateChild(R.layout.detail_item_card)
                )
            }
            DetailItem.Types.DETAIL_SESSION_ITEM -> {
                DetailSessionViewHolder(
                    parent.inflateChild(R.layout.detail_item_session)
                )
            }
            else -> throw IllegalArgumentException("Unknown type")
        }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
