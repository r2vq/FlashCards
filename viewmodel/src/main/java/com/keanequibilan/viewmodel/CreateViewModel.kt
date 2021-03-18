package com.keanequibilan.viewmodel

import androidx.lifecycle.ViewModel

abstract class CreateViewModel: ViewModel() {
    abstract fun createCard(name: String)
}
