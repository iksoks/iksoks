package com.xo.iksoks

import com.xo.iksoks.Constants.BOARD_SIZE
import com.xo.iksoks.Square.*

data class IksOks(
    var gameWon: Boolean = false,
    var xPlaying: Boolean = true,
    var isDraw: Boolean = false,
    var matrix: MutableList<MutableList<Int>> = mutableListOf(),
) {

    fun setup() {
        gameWon = false
        isDraw = false
        xPlaying = true
        matrix = generateMatrix()
    }

    fun play(x: Int, y: Int) {
        val move = isXOrO()
        matrix[x][y] = move
        gameWon = isWinningMove(x, y, move)
        if (!gameWon) {
            xPlaying = !xPlaying
        }
    }

    private fun generateMatrix() = generateSequence {
        generateSequence { EMPTY.value }.take(BOARD_SIZE).toMutableList()
    }.take(BOARD_SIZE).toMutableList()

    private fun isXOrO(): Int = if (xPlaying) X.value else O.value

    private fun isWinningMove(x: Int, y: Int, move: Int): Boolean {
        if (isRowWinning(x, move)) return true
        if (isColumnWinning(y, move)) return true
        if (isDiagonalWinning(x, y, move)) return true
        if (isReverseDiagonalWinning(x, y, move)) return true

        return false
    }

    private fun isColumnWinning(y: Int, move: Int): Boolean {
        for (i in 0 until BOARD_SIZE) {
            if (matrix[i][y] != move) {
                break
            }
            if (i == BOARD_SIZE - 1) {
                return true
            }
        }
        return false
    }

    private fun isRowWinning(x: Int, move: Int): Boolean {
        for (i in 0 until BOARD_SIZE) {
            if (matrix[x][i] != move) {
                break
            }
            if (i == BOARD_SIZE - 1) {
                return true
            }
        }
        return false
    }

    private fun isDiagonalWinning(x: Int, y: Int, move: Int): Boolean {
        if (x == y) {
            for (i in 0 until BOARD_SIZE) {
                if (matrix[i][i] != move) {
                    break
                }
                if (i == BOARD_SIZE - 1) {
                    return true
                }
            }
        }
        return false
    }

    private fun isReverseDiagonalWinning(x: Int, y: Int, move: Int): Boolean {
        if (x + y == BOARD_SIZE - 1) {
            for (i in 0 until BOARD_SIZE) {
                if (matrix[i][(BOARD_SIZE - 1) - i] != move) {
                    break
                }
                if (i == BOARD_SIZE - 1) {
                    return true
                }
            }
        }
        return false
    }


}
