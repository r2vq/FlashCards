package com.keanequibilan.repository

import androidx.paging.DataSource
import com.keanequibilan.repository.model.LocalFlashCard
import com.keanequibilan.repository.model.LocalSwipeCard

interface Repository {
    suspend fun getCards(): List<LocalSwipeCard>

    fun getCardsPaged(): DataSource.Factory<Int, LocalFlashCard>

    suspend fun createCard(
        front: String,
        back: String
    )

    suspend fun deleteCard(id: Int)

    suspend fun createSession()

    suspend fun updateCardSession(
        cardId: Int,
        correct: Int = 0,
        incorrect: Int = 0,
        skip: Int = 0
    )
}
