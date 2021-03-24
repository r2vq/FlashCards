package com.keanequibilan.screenlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.keanequibilan.repository.Repository
import com.keanequibilan.screenlist.model.ListItem
import com.keanequibilan.screenlist.util.toListItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class ListViewModel(
    private val repo: Repository
) : ViewModel() {
    val listItems: LiveData<PagedList<ListItem>> = repo
        .getCardsPaged()
        .map { card -> card.toListItem() }
        .toLiveData(pageSize = 50)

    fun deleteItem(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        repo.deleteCard(id)
    }

    fun clearCounts() = viewModelScope.launch(Dispatchers.IO) {
        repo.createSession()
    }
}
