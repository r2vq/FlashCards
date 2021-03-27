package com.keanequibilan.feature_list.impl.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keanequibilan.feature_list.impl.model.DetailItem
import com.keanequibilan.feature_list.impl.util.toDetailItems
import com.keanequibilan.layer_repo.Repository
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
