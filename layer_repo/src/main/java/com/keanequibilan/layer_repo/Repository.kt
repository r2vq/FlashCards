package com.keanequibilan.layer_repo

import androidx.paging.DataSource
import com.keanequibilan.layer_repo.model.LocalCardDetails
import com.keanequibilan.layer_repo.model.LocalFlashCard
import com.keanequibilan.layer_repo.model.LocalSwipeCard

interface Repository {
    suspend fun getCards(): List<LocalSwipeCard>

    suspend fun getCardDetails(id: Int): LocalCardDetails?

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
