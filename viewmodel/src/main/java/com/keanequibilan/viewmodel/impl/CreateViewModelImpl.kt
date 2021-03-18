package com.keanequibilan.viewmodel.impl

import androidx.lifecycle.viewModelScope
import com.keanequibilan.repository.Repository
import com.keanequibilan.viewmodel.CreateViewModel
import kotlinx.coroutines.launch

internal class CreateViewModelImpl(
    private val repo: Repository
) : CreateViewModel() {
    override fun createCard(name: String) {
        viewModelScope.launch {
            repo.createCard(name)
        }
    }
}
