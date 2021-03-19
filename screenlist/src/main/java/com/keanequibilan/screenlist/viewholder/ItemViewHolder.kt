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

internal class CardListItemViewHolder(itemView: View) : ItemViewHolder(itemView) {
    private val tvName: AppCompatTextView = itemView.findViewById(R.id.tv_name)

    override fun bind(item: ListItem?) {
        tvName.text = (item as? CardListItem)?.name
    }
}
