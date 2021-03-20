package com.keanequibilan.screenswipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.keanequibilan.screenswipe.adapter.CardAdapter
import com.keanequibilan.screenswipe.viewmodel.SwipeViewModel
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackView
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class SwipeFragment : Fragment() {

    private val adapter: CardAdapter by inject()
    private val swipeViewModel: SwipeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_swipe, container, false)

        val svCards = view.findViewById<CardStackView>(R.id.sv_cards)
        svCards.layoutManager = CardStackLayoutManager(context)
        svCards.adapter = adapter

        swipeViewModel.listItems.observe(viewLifecycleOwner) { items -> adapter.submitList(items) }

        return view
    }
}
