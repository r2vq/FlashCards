package com.keanequibilan.di

import com.keanequibilan.database.DATABASE_MODULE
import com.keanequibilan.repository.REPOSITORY_MODULE

val DI_MODULES = listOf(
    DATABASE_MODULE,
    REPOSITORY_MODULE
)
