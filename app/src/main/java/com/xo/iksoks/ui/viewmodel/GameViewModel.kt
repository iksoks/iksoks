package com.xo.iksoks.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.xo.iksoks.domain.IksOks
import com.xo.iksoks.domain.Square.Companion.BOARD_SIZE
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val iksOks: MutableState<IksOks> = mutableStateOf(
        savedStateHandle.get<IksOks>(CURRENT_IKSOKS) ?: IksOks().apply { setup() }
    )

    fun setupMatrix() {
        iksOks.value = IksOks().apply {
            setup()
            savedStateHandle.set(CURRENT_IKSOKS, this)
        }
    }

    fun play(position: Int) {
        val x = position / BOARD_SIZE
        val y = position % BOARD_SIZE

        IksOks(
            xPlaying = iksOks.value.xPlaying,
            draw = iksOks.value.draw,
            gameWon = iksOks.value.gameWon,
            matrix = iksOks.value.matrix
        ).apply {
            play(x, y)
        }.also {
            iksOks.value = it
            savedStateHandle.set(CURRENT_IKSOKS, it)
        }

    }

    companion object {
        private const val CURRENT_IKSOKS = "current_iksoks"
    }

}