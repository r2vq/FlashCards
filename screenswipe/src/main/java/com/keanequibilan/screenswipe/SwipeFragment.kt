package com.keanequibilan.screenswipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.keanequibilan.screenswipe.adapter.CardAdapter
import com.keanequibilan.screenswipe.viewmodel.SwipeViewModel
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.CardStackView
import com.yuyakaido.android.cardstackview.Direction
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

        adapter.setOnItemClickListener { id -> swipeViewModel.toggleItem(id) }

        val svCards = view.findViewById<CardStackView>(R.id.sv_cards)
        cardStackLayoutManager = CardStackLayoutManager(context, this)
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
