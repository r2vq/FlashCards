package com.keanequibilan.screenswipe.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keanequibilan.repository.Repository
import com.keanequibilan.screenswipe.model.CardItem
import com.keanequibilan.screenswipe.util.toCardItem
import kotlinx.coroutines.launch
import java.util.*

internal class SwipeViewModel(
    repo: Repository,
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
}
