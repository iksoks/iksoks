package com.xo.iksoks.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.xo.iksoks.domain.IksOks
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor() : ViewModel() {

    val iksOks: MutableState<IksOks> = mutableStateOf(IksOks())

    init {
        setupMatrix()
    }

    fun setupMatrix() {
        iksOks.value = IksOks().apply {
            setup()
        }
    }
}