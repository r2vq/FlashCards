package com.keanequibilan.layer_db.model

data class DbCurrentCardSession internal constructor(
    val id: Int,
    val sessionId: Int,
    val front: String,
    val back: String,
    val correct: Int,
    val incorrect: Int,
    val skip: Int
)
