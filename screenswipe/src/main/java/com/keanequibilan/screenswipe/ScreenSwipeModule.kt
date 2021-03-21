package com.keanequibilan.screenswipe

import com.keanequibilan.repository.Repository
import com.keanequibilan.screenswipe.adapter.CardAdapter
import com.keanequibilan.screenswipe.viewmodel.SwipeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.util.*

val SCREEN_SWIPE_MODULE = module {
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
