package com.keanequibilan.screenlist.viewholder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.keanequibilan.screenlist.R
import com.keanequibilan.screenlist.model.CardListItem
import com.keanequibilan.screenlist.model.ListItem

internal sealed class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: ListItem?)
}

internal class CardListItemViewHolder(
    itemView: View,
    onClick: ((item: CardListItem) -> Unit),
    onLongPress: ((item: CardListItem) -> Unit)
) : ItemViewHolder(itemView) {
    private val tvName: AppCompatTextView = itemView.findViewById(R.id.tv_name)
    private val tvCorrect: AppCompatTextView = itemView.findViewById(R.id.tv_correct)
    private val tvIncorrect: AppCompatTextView = itemView.findViewById(R.id.tv_incorrect)
    private var cardListItem: CardListItem? = null

    init {
        itemView.setOnClickListener {
            cardListItem?.let(onClick)
        }
        itemView.setOnLongClickListener {
            cardListItem?.let(onLongPress) != null
        }
    }

    override fun bind(item: ListItem?) {
        (item as? CardListItem)?.let {
            cardListItem = it
            tvName.text = it.name
            tvCorrect.text = itemView.context.getString(R.string.correct, it.correct)
            tvIncorrect.text = itemView.context.getString(R.string.incorrect, it.incorrect)
        } ?: run {
            cardListItem = null
            tvName.text = ""
            tvCorrect.text = ""
            tvIncorrect.text = ""
        }
    }
}
