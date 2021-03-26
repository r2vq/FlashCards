package com.keanequibilan.database.model

data class DbCurrentCardSession(
    val id: Int,
    val sessionId: Int,
    val front: String,
    val back: String,
    val correct: Int,
    val incorrect: Int,
    val skip: Int
)
