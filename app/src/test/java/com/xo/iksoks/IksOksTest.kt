package com.xo.iksoks

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class IksOksTest{
    class IksOksTest{

        lateinit var iksOks: IksOks

        @Before
        fun setUp(){
            iksOks = IksOks()
        }

        @Test
        fun shouldGameWonBeFalseOnSetup(){
            assertThat(iksOks.gameWon).isEqualTo(false)
        }

        @Test
        fun shouldMatrixBeEmptyOnSetup(){
            assertThat(iksOks.matrix).isEmpty()
        }

        @Test
        fun shouldInitializeMatrixSizeToThree(){
            assertThat(Constants.BOARD_SIZE).isEqualTo(3)
        }

        @Test
        fun shouldInitializeGameWonToFalseOnSetup(){
            iksOks.setup()
            assertThat(iksOks.gameWon).isEqualTo(false)
        }

    }
}