package com.keanequibilan.layer_db.model

data class DbCardSession internal constructor(
    val cardId: Int,
    val sessionId: Int,
    val correct: Int,
    val incorrect: Int,
    val skip: Int
)
