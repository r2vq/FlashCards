package com.keanequibilan.repository.model

data class LocalCardDetails(
    val id: Int,
    val front: String,
    val back: String,
    val sessions: List<DetailsSession>
)

data class DetailsSession(
    val id: Int,
    val correct: Int,
    val incorrect: Int,
    val skips: Int
)
