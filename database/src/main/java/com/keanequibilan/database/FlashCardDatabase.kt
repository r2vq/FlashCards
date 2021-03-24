package com.keanequibilan.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.keanequibilan.database.dao.CardSessionDao
import com.keanequibilan.database.dao.CardSessionViewDao
import com.keanequibilan.database.dao.FlashCardDao
import com.keanequibilan.database.dao.SessionDao
import com.keanequibilan.database.entity.CardSessionEntity
import com.keanequibilan.database.entity.CardSessionView
import com.keanequibilan.database.entity.FlashCardEntity
import com.keanequibilan.database.entity.SessionEntity

@Database(
    entities = [
        FlashCardEntity::class,
        SessionEntity::class,
        CardSessionEntity::class
    ],
    views = [
        CardSessionView::class
    ],
    version = 1
)
abstract class FlashCardDatabase : RoomDatabase() {
    abstract fun flashCardDao(): FlashCardDao
    abstract fun sessionDao(): SessionDao
    abstract fun cardSessionDao(): CardSessionDao
    abstract fun cardSessionViewDao(): CardSessionViewDao
}
