package com.keanequibilan.feature_list.impl.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.keanequibilan.feature_list.R
import com.keanequibilan.feature_list.impl.adapter.CardAdapter
import com.keanequibilan.feature_list.impl.viewmodel.ListViewModel
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

internal class ListFragment : Fragment() {

    private val adapter: CardAdapter by inject()
    private val listViewModel: ListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        adapter.setOnItemClickListener {
            val args = bundleOf("cardId" to it.id)
            findNavController(this@ListFragment)
                .navigate(R.id.action_listFragment_to_detailsFragment, args)
        }

        adapter.setOnItemLongPressListener { item ->
            AlertDialog
                .Builder(context)
                .setMessage(getString(R.string.delete_message, item.name))
                .setPositiveButton(R.string.yes) { _, _ ->
                    listViewModel.deleteItem(item.id)
                }
                .setNegativeButton(R.string.no) { _, _ -> }
                .create()
                .show()
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_list)
        recyclerView.adapter = adapter

        listViewModel.listItems.observe(viewLifecycleOwner) { items -> adapter.submitList(items) }

        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.screenlist_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_item_new_session -> {
                AlertDialog
                    .Builder(context)
                    .setMessage(getString(R.string.new_session_message))
                    .setPositiveButton(R.string.yes) { _, _ ->
                        listViewModel.clearCounts()
                    }
                    .setNegativeButton(R.string.no) { _, _ -> }
                    .create()
                    .show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
