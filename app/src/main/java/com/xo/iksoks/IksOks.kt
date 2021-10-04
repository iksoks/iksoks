package com.xo.iksoks

data class IksOks(
    val gameWon: Boolean = false,
    val matrix: MutableList<MutableList<Int>> = mutableListOf()
)
