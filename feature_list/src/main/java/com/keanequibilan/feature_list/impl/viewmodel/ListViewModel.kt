package com.keanequibilan.feature_list.impl.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.keanequibilan.feature_list.impl.model.ListItem
import com.keanequibilan.feature_list.impl.util.toListItem
import com.keanequibilan.layer_repo.Repository
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
