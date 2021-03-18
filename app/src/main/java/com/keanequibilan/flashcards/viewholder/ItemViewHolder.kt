package com.keanequibilan.flashcards.viewholder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.keanequibilan.flashcards.R
import com.keanequibilan.viewmodel.model.CardListItem
import com.keanequibilan.viewmodel.model.ListItem

sealed class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: ListItem?)
}

class CardListItemViewHolder(itemView: View) : ItemViewHolder(itemView) {
    private val tvName: AppCompatTextView = itemView.findViewById(R.id.tv_name)

    override fun bind(item: ListItem?) {
        tvName.text = (item as? CardListItem)?.name
    }
}
