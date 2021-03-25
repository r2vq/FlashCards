package com.keanequibilan.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FlashCardEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val front: String,
    val back: String
)
