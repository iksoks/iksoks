package com.xo.iksoks

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import com.xo.iksoks.Square.*

class IksOksTest{
    class IksOksTest{

        lateinit var iksOks: IksOks

        @Before
        fun setUp(){
            iksOks = IksOks()
        }

        @Test
        fun shouldGameWonBeFalseOnCreation(){
            assertThat(iksOks.gameWon).isFalse()
        }

        @Test
        fun shouldMatrixBeEmptyOnCreation(){
            assertThat(iksOks.matrix).isEmpty()
        }

        @Test
        fun shouldInitializeMatrixSizeToThreeOnCreation(){
            assertThat(Constants.BOARD_SIZE).isEqualTo(3)
        }

        @Test
        fun shouldInitializeGameWonToFalseOnSetup(){
            iksOks.setup()
            assertThat(iksOks.gameWon).isFalse()
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

            assertThat(iksOks.matrix[0][0]).isEqualTo(X.value)
        }

        @Test
        fun shouldChangeMatrixWhenLastSquareIsPlayed(){
            iksOks.setup()
            iksOks.play(2,2)

            assertThat(iksOks.matrix[2][2]).isEqualTo(X.value)
        }

        @Test
        fun shouldInitializeXPlayingOnCreation(){
            assertThat(iksOks.xPlaying).isTrue()
        }

        @Test
        fun shouldInitializeXPlayingOnSetup(){
            iksOks.setup()
            assertThat(iksOks.xPlaying).isTrue()
        }

        @Test
        fun shouldChangePlayerWhenPlayIsDone(){
            iksOks.setup()
            iksOks.play(0,0)

            assertThat(iksOks.xPlaying).isFalse()
        }

        @Test
        fun shouldChangePlayerBackXPlayingWhenPlayedTwice(){
            iksOks.setup()
            iksOks.play(0,0)
            iksOks.play(1,1)

            assertThat(iksOks.xPlaying).isTrue()
        }

        @Test
        fun shouldSetOtoPlayOnSecondPlay(){
            iksOks.setup()
            iksOks.play(0,0)
            iksOks.play(1,1)

            assertThat(iksOks.matrix[1][1]).isEqualTo(O.value)
        }

        @Test
        fun shouldPlayThreeXOnRowOneToWin(){
            iksOks.setup()
            iksOks.play(0,0) //X
            iksOks.play(1,0) //O
            iksOks.play(0,1) //X
            iksOks.play(1,1) //O
            iksOks.play(0,2) //X

            assertThat(iksOks.gameWon).isTrue()
        }

        @Test
        fun shouldPlayThreeOOnRowOneForOToWin(){
            iksOks.setup()
            iksOks.play(1,0) //X
            iksOks.play(0,0) //O
            iksOks.play(1,1) //X
            iksOks.play(0,1) //O
            iksOks.play(2,2) //X
            iksOks.play(0,2) //O

            assertThat(iksOks.gameWon).isTrue()
            assertThat(iksOks.xPlaying).isFalse()
        }

        @Test
        fun shouldPlayThreeXOnColumnOneToWin(){
            iksOks.setup()
            iksOks.play(0,0) //X
            iksOks.play(0,1) //O
            iksOks.play(1,0) //X
            iksOks.play(0,1) //O
            iksOks.play(2,0) //X

            assertThat(iksOks.gameWon).isTrue()
        }

        @Test
        fun shouldPlayThreeOOnColumnTwoForOToWin(){
            iksOks.setup()
            iksOks.play(2,2) //X
            iksOks.play(1,0) //O
            iksOks.play(0,1) //X
            iksOks.play(1,1) //O
            iksOks.play(0,2) //X
            iksOks.play(1,2) //O

            assertThat(iksOks.gameWon).isTrue()
            assertThat(iksOks.xPlaying).isFalse()

        }

        @Test
        fun shouldPlayThreeXonDiagonalForTheWin(){
            iksOks.setup()
            iksOks.play(0,0) //X
            iksOks.play(1,0) //O
            iksOks.play(1,1) //X
            iksOks.play(0,2) //O
            iksOks.play(2,2) //X

            assertThat(iksOks.gameWon).isTrue()
            assertThat(iksOks.xPlaying).isTrue()
        }

        @Test
        fun shouldPlayThreeXonDiagonalInReverseOrderForTheWin(){
            iksOks.setup()
            iksOks.play(2,2) //X
            iksOks.play(1,0) //O
            iksOks.play(1,1) //X
            iksOks.play(0,2) //O
            iksOks.play(0,0) //X

            assertThat(iksOks.gameWon).isTrue()
        }

        @Test
        fun shouldPlayThreeXonReverseDiagonalToWin(){
            iksOks.setup()
            iksOks.play(0,2) //X
            iksOks.play(0,1) //O
            iksOks.play(1,1) //X
            iksOks.play(2,2) //O
            iksOks.play(2,0) //X

            assertThat(iksOks.gameWon).isTrue()
        }


        @Test
        fun shouldPlayThreeXonReverseDiagonalInReverseOrderToWin(){
            iksOks.setup()
            iksOks.play(2,0) //X
            iksOks.play(0,1) //O
            iksOks.play(1,1) //X
            iksOks.play(2,2) //O
            iksOks.play(0,2) //X

            assertThat(iksOks.gameWon).isTrue()
        }

        @Test
        fun shouldInitializeDrawOnCreation(){
            iksOks.setup()

            assertThat(iksOks.isDraw).isFalse()
        }

        @Test
        fun shouldInitializeDrawOnSetup(){
            iksOks.setup()

            assertThat(iksOks.isDraw).isFalse()
        }

    }
}