package com.keanequibilan.layer_db.model

data class DbCardDetails(
    val card: DbCard,
    val sessions: List<DbCardSession>
)
