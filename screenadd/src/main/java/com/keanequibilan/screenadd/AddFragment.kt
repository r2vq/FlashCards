package com.keanequibilan.screenadd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import com.keanequibilan.screenadd.util.getTextOrNull
import com.keanequibilan.screenadd.viewmodel.AddViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class AddFragment : Fragment() {

    private val addViewModel: AddViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        val tilFront = view.findViewById<TextInputLayout>(R.id.el_front)
        val tilBack = view.findViewById<TextInputLayout>(R.id.el_back)

        view.findViewById<AppCompatButton>(R.id.btn_add).setOnClickListener {
            val front = tilFront.getTextOrNull()
            val back = tilBack.getTextOrNull()

            if (front != null && back != null) {
                addViewModel.createCard(front, back)

                tilFront.editText?.text?.clear()
                tilBack.editText?.text?.clear()
            }
        }
        return view
    }
}
