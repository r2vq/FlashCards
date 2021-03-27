package com.keanequibilan.feature_list.impl.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.keanequibilan.feature_list.R
import com.keanequibilan.feature_list.impl.diffutil.DetailItemDiffUtil
import com.keanequibilan.feature_list.impl.model.DetailItem
import com.keanequibilan.feature_list.impl.viewholder.DetailCardViewHolder
import com.keanequibilan.feature_list.impl.viewholder.DetailSessionViewHolder
import com.keanequibilan.feature_list.impl.viewholder.DetailViewHolder
import com.keanequibilan.layer_common.util.inflateChild

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
