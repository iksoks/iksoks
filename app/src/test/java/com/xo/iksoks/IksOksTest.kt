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

        @Test
        fun shouldInitializeMatrixToThreeRowsThreeOnSetup(){
            iksOks.setup()
            assertThat(iksOks.matrix).hasSize(3)
        }

        @Test
        fun shouldInitializeMatrixToThreeColumnsOnSetup(){
            iksOks.setup()
            assertThat(iksOks.matrix[0]).hasSize(3)
            assertThat(iksOks.matrix[1]).hasSize(3)
            assertThat(iksOks.matrix[2]).hasSize(3)
        }

        @Test
        fun shouldChangeMatrixWhenFirstSquareIsPlayed(){
            iksOks.setup()
            iksOks.play(0,0)

            assertThat(iksOks.matrix[0][0]).isEqualTo(1)
        }

        @Test
        fun shouldChangeMatrixWhenLastSquareIsPlayed(){
            iksOks.setup()
            iksOks.play(2,2)

            assertThat(iksOks.matrix[2][2]).isEqualTo(1)
        }

        @Test
        fun shouldInitializeXPlayingOnCreation(){
            assertThat(iksOks.xPlaying).isEqualTo(true)
        }

    }
}