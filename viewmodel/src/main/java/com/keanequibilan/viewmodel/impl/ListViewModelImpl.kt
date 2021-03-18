package com.keanequibilan.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.keanequibilan.repository.Repository
import com.keanequibilan.viewmodel.ListViewModel
import com.keanequibilan.viewmodel.model.ListItem
import com.keanequibilan.viewmodel.util.toListItem

internal class ListViewModelImpl(
    repo: Repository
) : ListViewModel() {
    override val listItems: LiveData<PagedList<ListItem>> = repo
        .getCardsPaged()
        .map { card -> card.toListItem() }
        .toLiveData(pageSize = 50)
}
