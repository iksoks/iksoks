package com.xo.iksoks.domain

enum class Square(
    val value: Int,
    val text: String,
) {
    EMPTY(0, ""),
    X(1, "X"),
    O(2, "O");

    companion object {
        const val BOARD_SIZE = 3
        fun fromInt(value: Int) = values().first { it.value == value }
    }

}
