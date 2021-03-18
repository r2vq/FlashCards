package com.keanequibilan.viewmodel

import com.keanequibilan.repository.Repository
import com.keanequibilan.viewmodel.impl.CreateViewModelImpl
import com.keanequibilan.viewmodel.impl.ListViewModelImpl
import org.koin.dsl.module

val VIEW_MODEL_MODULE = module {
    single<ListViewModel> {
        val repository: Repository = get()
        ListViewModelImpl(
            repo = repository
        )
    }

    single<CreateViewModel> {
        val repository: Repository = get()
        CreateViewModelImpl(
            repo = repository
        )
    }
}
