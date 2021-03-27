package com.keanequibilan.feature_add

import com.keanequibilan.feature_add.impl.viewmodel.AddViewModel
import com.keanequibilan.repository.Repository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val FEATURE_ADD_MODULE = module {
    viewModel {
        val repository: Repository = get()
        AddViewModel(
            repo = repository
        )
    }
}
