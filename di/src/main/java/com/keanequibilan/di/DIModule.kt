package com.keanequibilan.di

import com.keanequibilan.database.DATABASE_MODULE
import com.keanequibilan.repository.REPOSITORY_MODULE
import com.keanequibilan.viewmodel.VIEW_MODEL_MODULE

val DI_MODULES = listOf(
    DATABASE_MODULE,
    REPOSITORY_MODULE,
    VIEW_MODEL_MODULE
)
