package com.keanequibilan.di

import com.keanequibilan.database.DATABASE_MODULE
import com.keanequibilan.repository.REPOSITORY_MODULE
import com.keanequibilan.screenadd.SCREEN_ADD_MODULE
import com.keanequibilan.screenlist.SCREEN_LIST_MODULE
import com.keanequibilan.screenswipe.SCREEN_SWIPE_MODULE

val DI_MODULES = listOf(
    DATABASE_MODULE,
    REPOSITORY_MODULE,
    SCREEN_ADD_MODULE,
    SCREEN_LIST_MODULE,
    SCREEN_SWIPE_MODULE
)
