package com.keanequibilan.database.impl.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.keanequibilan.database.impl.entity.SessionEntity

@Dao
internal interface SessionDao {
    @Query("SELECT * FROM SessionEntity ORDER BY `id` DESC LIMIT 1")
    suspend fun getCurrentSession(): SessionEntity?

    @Insert
    suspend fun insertAll(vararg session: SessionEntity)
}
