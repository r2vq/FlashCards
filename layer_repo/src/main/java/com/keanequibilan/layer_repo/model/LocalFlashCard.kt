package com.keanequibilan.layer_repo.model

data class LocalFlashCard internal constructor(
    val id: Int,
    val front: String,
    val back: String,
    val correct: Int,
    val incorrect: Int
)
