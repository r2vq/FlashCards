package com.keanequibilan.database.impl.util

import com.keanequibilan.database.impl.entity.SessionEntity
import com.keanequibilan.database.model.DbSession

internal fun SessionEntity.toDbSession(): DbSession = DbSession(
    id = id
)
