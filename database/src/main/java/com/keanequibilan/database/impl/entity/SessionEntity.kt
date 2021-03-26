package com.keanequibilan.database.impl.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
internal data class SessionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
