package com.xo.iksoks

import com.xo.iksoks.Constants.BOARD_SIZE
import com.xo.iksoks.Square.*

data class IksOks(
    var gameWon: Boolean = false,
    var xPlaying: Boolean = true,
    var matrix: MutableList<MutableList<Int>> = mutableListOf()
){

    fun setup(){
        gameWon = false
        matrix = generateMatrix()
    }

    fun play(x: Int, y: Int){
        matrix[x][y] = isXOrO()
        xPlaying = !xPlaying
    }

    private fun generateMatrix() = generateSequence {
        generateSequence { EMPTY.value }.take(BOARD_SIZE).toMutableList()
    }.take(BOARD_SIZE).toMutableList()

    private fun isXOrO(): Int = if (xPlaying) X.value else O.value

}
