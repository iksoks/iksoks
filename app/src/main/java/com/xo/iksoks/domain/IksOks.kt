package com.xo.iksoks.domain

import android.os.Parcelable
import com.xo.iksoks.domain.Square.*
import com.xo.iksoks.domain.Square.Companion.BOARD_SIZE
import kotlinx.parcelize.Parcelize

typealias Matrix = MutableList<MutableList<Int>>

@Parcelize
data class IksOks(
    var gameWon: Boolean = false,
    var xPlaying: Boolean = true,
    var draw: Boolean = false,
    var matrix: Matrix = mutableListOf(),
) : Parcelable {

    fun setup() {
        gameWon = false
        draw = false
        xPlaying = true
        matrix = generateMatrix()
    }

    fun play(x: Int, y: Int) {
        val move = isXOrO()
        matrix[x][y] = move

        gameWon = isWinningMove(x, y, move)

        if (gameWon) return

        draw = isDraw()
        xPlaying = !xPlaying
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

    private fun isDraw() = matrix.flatten().none { it == EMPTY.value }

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
