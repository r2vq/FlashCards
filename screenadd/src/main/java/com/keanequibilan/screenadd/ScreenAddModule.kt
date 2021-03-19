package com.keanequibilan.screenadd

import com.keanequibilan.repository.Repository
import com.keanequibilan.screenadd.viewmodel.AddViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val SCREEN_ADD_MODULE = module {
    viewModel {
        val repository: Repository = get()
        AddViewModel(
            repo = repository
        )
    }
}
