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

internal class FrontCardItemViewHolder(itemView: View) :
    CardItemViewHolder(itemView) {
    private val tvMessage = itemView.findViewById<AppCompatTextView>(R.id.tv_message)

    override fun bind(item: CardItem?) = (item as? FrontCardItem)?.let {
        tvMessage.text = item.message
    } ?: run {
        tvMessage.text = ""
    }
}

internal class BackCardItemViewHolder(itemView: View) :
    CardItemViewHolder(itemView) {
    private val tvMessage = itemView.findViewById<AppCompatTextView>(R.id.tv_message)

    override fun bind(item: CardItem?) = (item as? BackCardItem)?.let {
        tvMessage.text = item.message
    } ?: run {
        tvMessage.text = ""
    }
}
