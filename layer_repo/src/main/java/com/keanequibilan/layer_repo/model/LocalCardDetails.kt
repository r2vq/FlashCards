package com.keanequibilan.layer_repo.model

data class LocalCardDetails internal constructor(
    val id: Int,
    val front: String,
    val back: String,
    val sessions: List<DetailsSession>
)

data class DetailsSession internal constructor(
    val id: Int,
    val correct: Int,
    val incorrect: Int,
    val skips: Int
)
