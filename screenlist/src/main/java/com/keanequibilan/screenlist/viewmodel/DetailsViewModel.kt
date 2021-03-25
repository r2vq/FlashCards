package com.keanequibilan.screenlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keanequibilan.repository.Repository
import com.keanequibilan.screenlist.model.DetailItem
import com.keanequibilan.screenlist.util.toDetailItems
import kotlinx.coroutines.launch

internal class DetailsViewModel(
    private val repo: Repository
) : ViewModel() {
    private val mutableDetailItem = MutableLiveData<List<DetailItem>>()
    val detailItemData: LiveData<List<DetailItem>> = mutableDetailItem

    fun getDetails(id: Int) {
        viewModelScope.launch {
            mutableDetailItem.postValue(repo.getCardDetails(id).toDetailItems())
        }
    }
}
