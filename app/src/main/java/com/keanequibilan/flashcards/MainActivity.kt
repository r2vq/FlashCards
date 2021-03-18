package com.keanequibilan.flashcards

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.keanequibilan.flashcards.adapter.CardAdapter
import com.keanequibilan.viewmodel.CreateViewModel
import com.keanequibilan.viewmodel.ListViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val listViewModel: ListViewModel by viewModel()
    private val createViewModel: CreateViewModel by viewModel()
    private val adapter: CardAdapter = CardAdapter()
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.rv_cards).adapter = adapter

        listViewModel.listItems.observe(this) {
            adapter.submitList(it)
        }

        val fab: FloatingActionButton = findViewById(R.id.fab_create)
        fab.setOnClickListener {
            createViewModel.createCard("Add new card ${++count}")
        }


    }
}
