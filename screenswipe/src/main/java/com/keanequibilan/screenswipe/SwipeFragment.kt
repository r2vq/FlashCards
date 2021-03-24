package com.keanequibilan.screenswipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import com.keanequibilan.screenswipe.adapter.CardAdapter
import com.keanequibilan.screenswipe.viewmodel.SwipeViewModel
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.CardStackView
import com.yuyakaido.android.cardstackview.Direction
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class SwipeFragment : Fragment(), CardStackListener {
    private val adapter: CardAdapter by inject()
    private val swipeViewModel: SwipeViewModel by viewModel()
    private lateinit var cardStackLayoutManager: CardStackLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_swipe, container, false)

        val svCards = view.findViewById<CardStackView>(R.id.sv_cards)

        view.findViewById<AppCompatImageView>(R.id.btn_incorrect)
            .setOnClickListener {
                val setting = SwipeAnimationSetting.Builder()
                    .setDirection(Direction.Left)
                    .build()
                cardStackLayoutManager.setSwipeAnimationSetting(setting)
                svCards.swipe()
            }
        view.findViewById<AppCompatImageView>(R.id.btn_unsure)
            .setOnClickListener {
                val setting = SwipeAnimationSetting.Builder()
                    .setDirection(Direction.Top)
                    .build()
                cardStackLayoutManager.setSwipeAnimationSetting(setting)
                svCards.swipe()
            }
        view.findViewById<AppCompatImageView>(R.id.btn_correct)
            .setOnClickListener {
                val setting = SwipeAnimationSetting.Builder()
                    .setDirection(Direction.Right)
                    .build()
                cardStackLayoutManager.setSwipeAnimationSetting(setting)
                svCards.swipe()
            }

        cardStackLayoutManager = CardStackLayoutManager(context, this)
        cardStackLayoutManager.setDirections(Direction.FREEDOM)
        svCards.layoutManager = cardStackLayoutManager
        svCards.adapter = adapter

        swipeViewModel.listItems.observe(viewLifecycleOwner) { items -> adapter.submitList(items) }

        return view
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {
        // no-op
    }

    override fun onCardSwiped(direction: Direction?) {
        val id = adapter.currentList[cardStackLayoutManager.topPosition - 1].id
        swipeViewModel.onSwipe(id, direction)
    }

    override fun onCardRewound() {
        // no-op
    }

    override fun onCardCanceled() {
        // no-op
    }

    override fun onCardAppeared(view: View?, position: Int) {
        // no-op
    }

    override fun onCardDisappeared(view: View?, position: Int) {
        // no-op
    }
}
