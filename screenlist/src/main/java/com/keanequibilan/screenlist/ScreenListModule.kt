package com.keanequibilan.screenlist

import com.keanequibilan.repository.Repository
import com.keanequibilan.screenlist.adapter.CardAdapter
import com.keanequibilan.screenlist.viewmodel.ListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val SCREEN_LIST_MODULE = module {
    factory {
        CardAdapter()
    }

    viewModel {
        val repository: Repository = get()

        ListViewModel(
            repo = repository
        )
    }
}
