package com.keanequibilan.screenswipe.viewholder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.keanequibilan.screenswipe.R
import com.keanequibilan.screenswipe.model.CardItem

internal class CardItemViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {
    private val cvCard = itemView.findViewById<CardView>(R.id.cv_card)
    private val clFront = itemView.findViewById<ConstraintLayout>(R.id.cl_front)
    private val clBack = itemView.findViewById<ConstraintLayout>(R.id.cl_back)
    private val tvMessage = itemView.findViewById<AppCompatTextView>(R.id.tv_message)
    private val tvOtherMessage = itemView.findViewById<AppCompatTextView>(R.id.tv_other_message)

    private val frontClickListener: (v: View) -> Unit = {
        cvCard.setOnClickListener(backClickListener)
        clFront.visibility = View.INVISIBLE
        clBack.visibility = View.VISIBLE
    }
    private val backClickListener: (v: View) -> Unit = {
        cvCard.setOnClickListener(frontClickListener)
        clFront.visibility = View.VISIBLE
        clBack.visibility = View.INVISIBLE
    }

    init {
        cvCard.setOnClickListener(frontClickListener)
    }

    fun bind(item: CardItem?) {
        clFront.visibility = View.VISIBLE
        clBack.visibility = View.INVISIBLE

        item?.let {
            tvMessage.text = item.message
            tvOtherMessage.text = item.otherMessage
        } ?: run {
            tvMessage.text = ""
            tvOtherMessage.text = ""
        }
    }
}
