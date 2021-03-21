package com.keanequibilan.screenswipe.viewholder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.keanequibilan.screenswipe.R
import com.keanequibilan.screenswipe.model.BackCardItem
import com.keanequibilan.screenswipe.model.CardItem
import com.keanequibilan.screenswipe.model.FrontCardItem

internal abstract class CardItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: CardItem?)
}

internal class UnknownViewHolder(itemView: View) :
    CardItemViewHolder(itemView) {
    override fun bind(item: CardItem?) {
        // no-op
    }
}

internal class FrontCardItemViewHolder(
    itemView: View,
    onItemClick: ((Int) -> Unit)
) : CardItemViewHolder(itemView) {
    private val tvMessage = itemView.findViewById<AppCompatTextView>(R.id.tv_message)
    private var frontCardItem: FrontCardItem? = null

    init {
        itemView.setOnClickListener { frontCardItem?.let { onItemClick(it.id) } }
    }

    override fun bind(item: CardItem?) = (item as? FrontCardItem)?.let {
        frontCardItem = it
        tvMessage.text = item.message
    } ?: run {
        frontCardItem = null
        tvMessage.text = ""
    }
}

internal class BackCardItemViewHolder(
    itemView: View,
    onItemClick: ((Int) -> Unit)
) : CardItemViewHolder(itemView) {
    private val tvMessage = itemView.findViewById<AppCompatTextView>(R.id.tv_message)
    private var backCardItem: BackCardItem? = null

    init {
        itemView.setOnClickListener { backCardItem?.let { onItemClick(it.id) } }
    }

    override fun bind(item: CardItem?) = (item as? BackCardItem)?.let {
        backCardItem = it
        tvMessage.text = item.message
    } ?: run {
        backCardItem = null
        tvMessage.text = ""
    }
}
