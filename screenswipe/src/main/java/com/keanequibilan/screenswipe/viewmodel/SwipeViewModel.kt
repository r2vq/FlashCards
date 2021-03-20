package com.keanequibilan.screenswipe.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.keanequibilan.repository.Repository
import com.keanequibilan.screenswipe.model.CardItem
import com.keanequibilan.screenswipe.util.toCardItem

internal class SwipeViewModel(
    repo: Repository
) : ViewModel() {
    val listItems: LiveData<PagedList<CardItem>> = repo
        .getCardsPaged()
        .map { card -> card.toCardItem() }
        .toLiveData(pageSize = 1)
}
