package com.keanequibilan.repository

import com.keanequibilan.database.FlashCardDatabase
import com.keanequibilan.repository.impl.RepositoryImpl
import org.koin.dsl.module

val REPOSITORY_MODULE = module {
    single<Repository> {
        val database: FlashCardDatabase = get()
        RepositoryImpl(
            db = database
        )
    }
}
