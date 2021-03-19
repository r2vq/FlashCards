package com.keanequibilan.flashcards

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab: FloatingActionButton = findViewById(R.id.fab_create)
        fab.setOnClickListener {
            findNavController(this@MainActivity, R.id.nav_host_fragment)
                .navigate(R.id.addFragment)
        }
    }
}
