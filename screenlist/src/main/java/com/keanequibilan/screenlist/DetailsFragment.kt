package com.keanequibilan.screenlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.keanequibilan.screenlist.adapter.DetailsAdapter
import com.keanequibilan.screenlist.viewmodel.DetailsViewModel
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

internal class DetailsFragment : Fragment() {

    private val detailsViewModel: DetailsViewModel by viewModel()
    private val adapter: DetailsAdapter by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_details, container, false)
        val rvDetails = view.findViewById<RecyclerView>(R.id.rv_details)

        rvDetails.adapter = adapter
        detailsViewModel.detailItemData.observe(viewLifecycleOwner) { items ->
            adapter.submitList(items)
        }

        val cardId = arguments?.getInt("cardId") ?: run {
            findNavController(this@DetailsFragment).popBackStack()
            return null
        }

        detailsViewModel.getDetails(cardId)

        return view
    }
}
