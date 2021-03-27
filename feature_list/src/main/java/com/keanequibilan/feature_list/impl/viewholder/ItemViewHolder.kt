package com.keanequibilan.feature_list.impl.viewholder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.keanequibilan.feature_list.R
import com.keanequibilan.feature_list.impl.model.CardListItem
import com.keanequibilan.feature_list.impl.model.ListItem

internal sealed class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: ListItem?)
}

internal class CardListItemViewHolder(
    itemView: View,
    onClick: ((item: CardListItem) -> Unit),
    onLongPress: ((item: CardListItem) -> Unit),
    type: ViewHolderType
) : ItemViewHolder(itemView) {
    private val clContainer: ConstraintLayout = itemView.findViewById(R.id.cl_container)
    private val tvName: AppCompatTextView = itemView.findViewById(R.id.tv_name)
    private val tvCorrect: AppCompatTextView = itemView.findViewById(R.id.tv_correct)
    private val tvBack: AppCompatTextView = itemView.findViewById(R.id.tv_back)
    private val tvIncorrect: AppCompatTextView = itemView.findViewById(R.id.tv_incorrect)
    private var cardListItem: CardListItem? = null

    init {
        clContainer.setBackgroundResource(
            when (type) {
                ViewHolderType.GOOD -> R.drawable.list_item_background_good
                ViewHolderType.NEUTRAL -> R.drawable.list_item_background_neutral
                ViewHolderType.BAD -> R.drawable.list_item_background_bad
            }
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
            tvBack.text = it.back
            tvIncorrect.text = itemView.context.getString(R.string.incorrect, it.incorrect)
        } ?: run {
            cardListItem = null
            tvName.text = ""
            tvCorrect.text = ""
            tvBack.text = ""
            tvIncorrect.text = ""
        }
    }

    enum class ViewHolderType {
        GOOD,
        NEUTRAL,
        BAD
    }
}
