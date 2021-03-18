package com.keanequibilan.repository

import androidx.paging.DataSource
import com.keanequibilan.repository.model.LocalFlashCard

interface Repository {
    suspend fun getCards(): List<LocalFlashCard>

    suspend fun getCard(
        id: Int
    ): LocalFlashCard?

    fun getCardsPaged(): DataSource.Factory<Int, LocalFlashCard>

    suspend fun createCard(
        name: String
    )
}
