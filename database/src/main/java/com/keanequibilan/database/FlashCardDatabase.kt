package com.keanequibilan.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.keanequibilan.database.dao.FlashCardDao
import com.keanequibilan.database.entity.FlashCardEntity

@Database(
    entities = [
        FlashCardEntity::class
    ],
    version = 1
)
abstract class FlashCardDatabase: RoomDatabase() {
    abstract fun flashCardDao(): FlashCardDao
}
