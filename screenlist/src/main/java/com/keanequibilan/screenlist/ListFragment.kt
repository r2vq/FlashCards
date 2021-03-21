package com.keanequibilan.screenlist

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.keanequibilan.screenlist.adapter.CardAdapter
import com.keanequibilan.screenlist.viewmodel.ListViewModel
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {

    private val adapter: CardAdapter by inject()
    private val listViewModel: ListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        adapter.setOnItemClickListener { item ->
            AlertDialog
                .Builder(context)
                .setMessage(getString(R.string.clear_counts_message, item.name))
                .setPositiveButton("Yes") { _, _ ->
                    listViewModel.clearCounts(item.id)
                }
                .setNegativeButton("No") { _, _ -> }
                .create()
                .show()
        }

        adapter.setOnItemLongPressListener { item ->
            AlertDialog
                .Builder(context)
                .setMessage(getString(R.string.delete_message, item.name))
                .setPositiveButton("Yes") { _, _ ->
                    listViewModel.deleteItem(item.id)
                }
                .setNegativeButton("No") { _, _ -> }
                .create()
                .show()
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_list)
        recyclerView.adapter = adapter

        listViewModel.listItems.observe(viewLifecycleOwner) { items -> adapter.submitList(items) }

        return view
    }
}
