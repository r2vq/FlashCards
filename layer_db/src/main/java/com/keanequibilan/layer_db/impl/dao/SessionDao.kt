package com.keanequibilan.layer_db.impl.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.keanequibilan.layer_db.impl.entity.SessionEntity

@Dao
internal interface SessionDao {
    @Query("SELECT * FROM SessionEntity ORDER BY `id` DESC LIMIT 1")
    suspend fun getCurrentSession(): SessionEntity?

    @Insert
    suspend fun insertAll(vararg session: SessionEntity)
}
