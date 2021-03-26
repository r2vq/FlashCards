package com.keanequibilan.database.impl.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.keanequibilan.database.impl.dao.CardSessionDao
import com.keanequibilan.database.impl.dao.CardSessionViewDao
import com.keanequibilan.database.impl.dao.FlashCardDao
import com.keanequibilan.database.impl.dao.SessionDao
import com.keanequibilan.database.impl.entity.CardSessionEntity
import com.keanequibilan.database.impl.entity.CardSessionView
import com.keanequibilan.database.impl.entity.FlashCardEntity
import com.keanequibilan.database.impl.entity.SessionEntity

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
internal abstract class FlashCardDatabase : RoomDatabase() {
    abstract fun flashCardDao(): FlashCardDao
    abstract fun sessionDao(): SessionDao
    abstract fun cardSessionDao(): CardSessionDao
    abstract fun cardSessionViewDao(): CardSessionViewDao
}
