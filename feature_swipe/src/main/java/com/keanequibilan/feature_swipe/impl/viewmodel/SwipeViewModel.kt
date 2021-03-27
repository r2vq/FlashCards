package com.keanequibilan.feature_swipe.impl.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keanequibilan.feature_swipe.impl.model.CardItem
import com.keanequibilan.feature_swipe.impl.util.toCardItem
import com.keanequibilan.layer_repo.Repository
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

    fun onSwipe(
        id: Int,
        direction: Direction?
    ) = viewModelScope.launch(Dispatchers.IO) {
        when (direction) {
            Direction.Right -> {
                repo.updateCardSession(id, correct = 1)
            }
            Direction.Left -> {
                repo.updateCardSession(id, incorrect = 1)
            }
            Direction.Top -> {
                repo.updateCardSession(id, skip = 1)
            }
            Direction.Bottom -> {
                repo.updateCardSession(id, skip = 1)
            }
        }
    }
}
