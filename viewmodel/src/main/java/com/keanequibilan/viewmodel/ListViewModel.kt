package com.keanequibilan.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.keanequibilan.viewmodel.model.ListItem

abstract class ListViewModel : ViewModel() {
    abstract val listItems: LiveData<PagedList<ListItem>>
}
