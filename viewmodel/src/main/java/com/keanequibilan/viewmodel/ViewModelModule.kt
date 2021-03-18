package com.keanequibilan.viewmodel

import com.keanequibilan.repository.Repository
import com.keanequibilan.viewmodel.impl.CreateViewModelImpl
import com.keanequibilan.viewmodel.impl.ListViewModelImpl
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val VIEW_MODEL_MODULE = module {
    viewModel<ListViewModel> {
        val repository: Repository = get()
        ListViewModelImpl(
            repo = repository
        )
    }

    viewModel<CreateViewModel> {
        val repository: Repository = get()
        CreateViewModelImpl(
            repo = repository
        )
    }
}
