package com.keanequibilan.screenlist.viewholder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
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
    onLongPress: ((item: CardListItem) -> Unit),
    type: ViewHolderType
) : ItemViewHolder(itemView) {
    private val cvCard: CardView = itemView.findViewById(R.id.cv_card)
    private val tvName: AppCompatTextView = itemView.findViewById(R.id.tv_name)
    private val tvCorrect: AppCompatTextView = itemView.findViewById(R.id.tv_correct)
    private val tvIncorrect: AppCompatTextView = itemView.findViewById(R.id.tv_incorrect)
    private var cardListItem: CardListItem? = null

    init {
        cvCard.setCardBackgroundColor(
            ContextCompat.getColor(
                itemView.context,
                when (type) {
                    ViewHolderType.GOOD -> R.color.design_default_color_primary
                    ViewHolderType.NEUTRAL -> android.R.color.darker_gray
                    ViewHolderType.BAD -> android.R.color.holo_red_dark
                }
            )
        )
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

    enum class ViewHolderType {
        GOOD,
        NEUTRAL,
        BAD
    }
}
