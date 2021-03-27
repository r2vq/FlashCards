package com.keanequibilan.feature_list

import com.keanequibilan.feature_list.impl.adapter.CardAdapter
import com.keanequibilan.feature_list.impl.adapter.DetailsAdapter
import com.keanequibilan.feature_list.impl.viewmodel.DetailsViewModel
import com.keanequibilan.feature_list.impl.viewmodel.ListViewModel
import com.keanequibilan.layer_repo.Repository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val FEATURE_LIST_MODULE =  module {
    factory {
        CardAdapter()
    }

    factory {
        DetailsAdapter()
    }

    viewModel {
        val repository: Repository = get()

        ListViewModel(
            repo = repository
        )
    }

    viewModel {
        val repository: Repository = get()

        DetailsViewModel(
            repo = repository
        )
    }
}
