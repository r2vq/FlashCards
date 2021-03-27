package com.keanequibilan.layer_db.impl.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class FlashCardEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val front: String,
    val back: String
)
