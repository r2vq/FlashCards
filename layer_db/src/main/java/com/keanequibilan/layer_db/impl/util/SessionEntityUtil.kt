package com.keanequibilan.layer_db.impl.util

import com.keanequibilan.layer_db.impl.entity.SessionEntity
import com.keanequibilan.layer_db.model.DbSession

internal fun SessionEntity.toDbSession(): DbSession = DbSession(
    id = id
)
