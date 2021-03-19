package com.keanequibilan.flashcards

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.keanequibilan.viewmodel.CreateViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val createViewModel: CreateViewModel by viewModel()
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab: FloatingActionButton = findViewById(R.id.fab_create)
        fab.setOnClickListener {
            createViewModel.createCard("Add new card ${++count}")
        }
    }
}
