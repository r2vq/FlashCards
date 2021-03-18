package com.keanequibilan.repository

import com.keanequibilan.repository.model.LocalFlashCard

interface Repository {
    suspend fun getCards(): List<LocalFlashCard>

    suspend fun getCard(id: Int): LocalFlashCard?

    suspend fun createCard(
        name: String
    )
}
