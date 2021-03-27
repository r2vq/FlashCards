package com.keanequibilan.feature_add.impl.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keanequibilan.repository.Repository
import kotlinx.coroutines.launch

internal class AddViewModel(
    private val repo: Repository
) : ViewModel() {
    fun createCard(front: String, back: String) {
        viewModelScope.launch {
            repo.createCard(front, back)
        }
    }
}
