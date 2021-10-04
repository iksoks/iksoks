package com.xo.iksoks

data class IksOks(
    var gameWon: Boolean = false,
    val matrix: MutableList<MutableList<Int>> = mutableListOf()
){

    fun setup(){
        gameWon = false
    }
}
