package com.keanequibilan.screenswipe.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keanequibilan.repository.Repository
import com.keanequibilan.screenswipe.model.BackCardItem
import com.keanequibilan.screenswipe.model.CardItem
import com.keanequibilan.screenswipe.model.FrontCardItem
import com.keanequibilan.screenswipe.util.toCardItem
import com.yuyakaido.android.cardstackview.Direction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

internal class SwipeViewModel(
    private val repo: Repository,
    random: Random
) : ViewModel() {
    private val mutableListItems: MutableLiveData<List<CardItem>> = MutableLiveData()
    val listItems: LiveData<List<CardItem>> = mutableListItems

    init {
        viewModelScope.launch {
            repo
                .getCards()
                .map { card -> card.toCardItem() }
                .toMutableList()
                .apply { shuffle(random) }
                .let { mutableListItems.postValue(it) }
        }
    }

    fun toggleItem(id: Int) {
        mutableListItems.value?.map { cardItem ->
            cardItem.takeUnless { it.id == id } ?: when (cardItem) {
                is FrontCardItem -> {
                    BackCardItem(
                        id = cardItem.id,
                        message = cardItem.otherMessage,
                        otherMessage = cardItem.message
                    )
                }
                is BackCardItem -> {
                    FrontCardItem(
                        id = cardItem.id,
                        message = cardItem.otherMessage,
                        otherMessage = cardItem.message
                    )
                }
            }
        }?.let { mutableListItems.postValue(it) }
    }

    fun onSwipe(
        id: Int,
        direction: Direction?
    ) = viewModelScope.launch(Dispatchers.IO) {
        when (direction) {
            Direction.Right -> {
                repo.incrementCorrect(id)
            }
            Direction.Left -> {
                repo.incrementIncorrect(id)
            }
            Direction.Top -> {
                /* no-op */
            }
            Direction.Bottom -> {
                /* no-op */
            }
        }
    }
}
