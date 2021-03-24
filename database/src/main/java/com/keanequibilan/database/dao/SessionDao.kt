package com.keanequibilan.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.keanequibilan.database.entity.SessionEntity

@Dao
interface SessionDao {
    @Query("SELECT * FROM SessionEntity ORDER BY `id` DESC LIMIT 1")
    suspend fun getCurrentSession(): SessionEntity?

    @Insert
    suspend fun insertAll(vararg session: SessionEntity)
}
