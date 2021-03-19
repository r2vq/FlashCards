package com.keanequibilan.screenlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.keanequibilan.repository.Repository
import com.keanequibilan.screenlist.model.ListItem
import com.keanequibilan.screenlist.util.toListItem

internal class ListViewModel(
    repo: Repository
) : ViewModel() {
    val listItems: LiveData<PagedList<ListItem>> = repo
        .getCardsPaged()
        .map { card -> card.toListItem() }
        .toLiveData(pageSize = 50)
}
