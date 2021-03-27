package com.keanequibilan.layer_db.impl.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import com.keanequibilan.layer_db.impl.entity.CardSessionView

@Dao
internal interface CardSessionViewDao {
    @Query("SELECT * FROM CardSessionView")
    fun getFlashCardPaged(): DataSource.Factory<Int, CardSessionView>
}
