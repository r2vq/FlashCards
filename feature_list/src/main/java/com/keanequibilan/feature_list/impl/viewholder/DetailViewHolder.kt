package com.keanequibilan.feature_list.impl.viewholder

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.keanequibilan.feature_list.R
import com.keanequibilan.feature_list.impl.model.DetailCardItem
import com.keanequibilan.feature_list.impl.model.DetailItem
import com.keanequibilan.feature_list.impl.model.DetailSessionItem

internal abstract class DetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: DetailItem)
}

internal class DetailCardViewHolder(itemView: View) : DetailViewHolder(itemView) {
    private val tvFront: AppCompatTextView = itemView.findViewById(R.id.tv_front)
    private val tvBack: AppCompatTextView = itemView.findViewById(R.id.tv_back)

    override fun bind(item: DetailItem) {
        (item as? DetailCardItem)?.let {
            tvFront.text = it.front
            tvBack.text = it.back
        } ?: run {
            tvFront.text = ""
            tvBack.text = ""
        }
    }
}

internal class DetailSessionViewHolder(itemView: View) : DetailViewHolder(itemView) {
    private val tvId: AppCompatTextView = itemView.findViewById(R.id.tv_id)
    private val tvCorrect: Chip = itemView.findViewById(R.id.tv_correct)
    private val tvIncorrect: Chip = itemView.findViewById(R.id.tv_incorrect)
    private val tvSkip: Chip = itemView.findViewById(R.id.tv_skip)

    override fun bind(item: DetailItem) {
        (item as? DetailSessionItem)?.let {
            tvId.text = "Session ${it.id}:"
            tvCorrect.text = "Correct: ${it.correct}"
            tvIncorrect.text = "Incorrect: ${it.incorrect}"
            tvSkip.text = "Skip: ${it.skips}"
        } ?: run {
            tvId.text = ""
            tvCorrect.text = ""
            tvIncorrect.text = ""
            tvSkip.text = ""
        }
    }
}
