package com.keanequibilan.layer_db.impl.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.keanequibilan.layer_db.impl.dao.CardSessionDao
import com.keanequibilan.layer_db.impl.dao.CardSessionViewDao
import com.keanequibilan.layer_db.impl.dao.FlashCardDao
import com.keanequibilan.layer_db.impl.dao.SessionDao
import com.keanequibilan.layer_db.impl.entity.CardSessionEntity
import com.keanequibilan.layer_db.impl.entity.CardSessionView
import com.keanequibilan.layer_db.impl.entity.FlashCardEntity
import com.keanequibilan.layer_db.impl.entity.SessionEntity

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
