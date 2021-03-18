package com.keanequibilan.repository.impl

import androidx.paging.DataSource
import com.keanequibilan.database.FlashCardDatabase
import com.keanequibilan.database.entity.FlashCardEntity
import com.keanequibilan.repository.Repository
import com.keanequibilan.repository.model.LocalFlashCard
import com.keanequibilan.repository.util.toLocalFlashCard

internal class RepositoryImpl(
    private val db: FlashCardDatabase
) : Repository {
    override suspend fun getCards(): List<LocalFlashCard> = db
        .flashCardDao()
        .getAll()
        .mapNotNull(FlashCardEntity?::toLocalFlashCard)

    override suspend fun getCard(id: Int): LocalFlashCard? = db
        .flashCardDao()
        .getFlashCard(id)
        .let(FlashCardEntity?::toLocalFlashCard)

    override fun getCardsPaged(): DataSource.Factory<Int, LocalFlashCard> = db
        .flashCardDao()
        .getFlashCardPaged()
        .map(FlashCardEntity?::toLocalFlashCard)

    override suspend fun createCard(name: String) = db
        .flashCardDao()
        .insertAll(FlashCardEntity(name = name))
}
