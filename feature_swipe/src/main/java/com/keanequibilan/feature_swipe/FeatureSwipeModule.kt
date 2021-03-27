package com.keanequibilan.feature_swipe

import com.keanequibilan.feature_swipe.impl.adapter.CardAdapter
import com.keanequibilan.feature_swipe.impl.viewmodel.SwipeViewModel
import com.keanequibilan.layer_repo.Repository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.util.*

val FEATURE_SWIPE_MODULE = module {
    factory {
        CardAdapter()
    }

    viewModel {
        val repository = get<Repository>()
        val random = Random(System.currentTimeMillis())
        SwipeViewModel(
            repo = repository,
            random = random
        )
    }
}
