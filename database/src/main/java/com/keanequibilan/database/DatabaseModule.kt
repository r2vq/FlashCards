package com.keanequibilan.database

import androidx.room.Room
import com.keanequibilan.database.impl.DatabaseClientImpl
import com.keanequibilan.database.impl.db.FlashCardDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val DATABASE_MODULE = module {
    single {
        Room
            .databaseBuilder(
                androidContext(),
                FlashCardDatabase::class.java,
                "flashcard-db"
            )
            .build()
    }

    single<DatabaseClient> {
        val database = get<FlashCardDatabase>()
        DatabaseClientImpl(
            db = database
        )
    }
}
