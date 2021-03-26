package com.keanequibilan.database.model

data class DbCardSession(
    val cardId: Int,
    val sessionId: Int,
    val correct: Int,
    val incorrect: Int,
    val skip: Int
)
