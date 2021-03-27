package com.keanequibilan.di

import com.keanequibilan.database.DATABASE_MODULE
import com.keanequibilan.feature_add.FEATURE_ADD_MODULE
import com.keanequibilan.feature_list.FEATURE_LIST_MODULE
import com.keanequibilan.repository.REPOSITORY_MODULE
import com.keanequibilan.screenswipe.SCREEN_SWIPE_MODULE

val DI_MODULES = listOf(
    DATABASE_MODULE,
    FEATURE_ADD_MODULE,
    FEATURE_LIST_MODULE,
    REPOSITORY_MODULE,
    SCREEN_SWIPE_MODULE
)
