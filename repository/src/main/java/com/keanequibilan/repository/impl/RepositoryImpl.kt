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

    override fun getCardsPaged(): DataSource.Factory<Int, LocalFlashCard> = db
        .flashCardDao()
        .getFlashCardPaged()
        .map(FlashCardEntity?::toLocalFlashCard)

    override suspend fun createCard(front: String, back: String) = db
        .flashCardDao()
        .insertAll(
            FlashCardEntity(
                front = front,
                back = back,
                correctCount = 0,
                incorrectCount = 0
            )
        )

    override suspend fun deleteCard(id: Int) = db
        .flashCardDao()
        .delete(id)

    override suspend fun incrementCorrect(id: Int) = db
        .flashCardDao()
        .incrementCorrect(id)

    override suspend fun incrementIncorrect(id: Int) = db
        .flashCardDao()
        .incrementIncorrect(id)
}
