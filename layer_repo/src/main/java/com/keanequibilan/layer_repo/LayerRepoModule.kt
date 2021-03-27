package com.keanequibilan.layer_repo

import com.keanequibilan.database.DatabaseClient
import com.keanequibilan.layer_repo.impl.RepositoryImpl
import org.koin.dsl.module

val LAYER_REPO_MODULE = module {
    single<Repository> {
        val database: DatabaseClient = get()
        RepositoryImpl(
            db = database
        )
    }
}
