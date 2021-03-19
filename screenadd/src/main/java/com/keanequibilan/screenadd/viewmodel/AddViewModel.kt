package com.keanequibilan.screenadd.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keanequibilan.repository.Repository
import kotlinx.coroutines.launch

internal class AddViewModel(
    private val repo: Repository
) : ViewModel() {
    fun createCard(name: String) {
        viewModelScope.launch {
            repo.createCard(name)
        }
    }
}
