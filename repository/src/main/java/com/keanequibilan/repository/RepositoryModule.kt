package com.keanequibilan.repository

import com.keanequibilan.database.DatabaseClient
import com.keanequibilan.repository.impl.RepositoryImpl
import org.koin.dsl.module

val REPOSITORY_MODULE = module {
    single<Repository> {
        val database: DatabaseClient = get()
        RepositoryImpl(
            db = database
        )
    }
}
