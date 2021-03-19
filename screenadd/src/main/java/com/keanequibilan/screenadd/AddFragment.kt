package com.keanequibilan.screenadd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import com.keanequibilan.screenadd.viewmodel.AddViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class AddFragment : Fragment() {

    private val addViewModel: AddViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        view.findViewById<AppCompatButton>(R.id.btn_add).setOnClickListener {
            val name = view.findViewById<AppCompatEditText>(R.id.et_name).text.toString()
            addViewModel.createCard(name)
        }
        return view
    }
}
