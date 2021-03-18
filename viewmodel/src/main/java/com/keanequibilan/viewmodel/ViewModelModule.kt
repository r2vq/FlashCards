package com.keanequibilan.viewmodel

import com.keanequibilan.repository.Repository
import com.keanequibilan.viewmodel.impl.ListViewModelImpl
import org.koin.dsl.module

val VIEW_MODEL_MODULE = module {
    single<ListViewModel> {
        val repository: Repository = get()
        ListViewModelImpl(
            repo = repository
        )
    }
}
