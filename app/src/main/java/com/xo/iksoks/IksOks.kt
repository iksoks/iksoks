package com.xo.iksoks

import com.xo.iksoks.Constants.BOARD_SIZE

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
        matrix[x][y] = 1
    }

    private fun generateMatrix() = generateSequence {
        generateSequence { 0 }.take(BOARD_SIZE).toMutableList()
    }.take(BOARD_SIZE).toMutableList()
}
