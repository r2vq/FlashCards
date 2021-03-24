package com.keanequibilan.database.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import com.keanequibilan.database.entity.CardSessionView

@Dao
interface CardSessionViewDao {
    @Query("SELECT * FROM CardSessionView")
    fun getFlashCardPaged(): DataSource.Factory<Int, CardSessionView>
}
