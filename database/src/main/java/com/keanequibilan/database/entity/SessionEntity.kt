package com.keanequibilan.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SessionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
