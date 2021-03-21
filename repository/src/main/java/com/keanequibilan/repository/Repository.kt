package com.keanequibilan.repository

import androidx.paging.DataSource
import com.keanequibilan.repository.model.LocalFlashCard

interface Repository {
    suspend fun getCards(): List<LocalFlashCard>

    fun getCardsPaged(): DataSource.Factory<Int, LocalFlashCard>

    suspend fun createCard(
        front: String,
        back: String
    )

    suspend fun deleteCard(id: Int)
}
