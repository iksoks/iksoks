package com.xo.iksoks

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.xo.iksoks.ui.game.GameActivity
import com.xo.iksoks.domain.Square.*
import org.junit.Rule
import org.junit.Test

class GameActivityTest{

    @get:Rule
    val composeAndroidTestRule = createAndroidComposeRule<GameActivity>()


    @Test
    fun shouldDisplayTextPleaseChooseASquareOnCreation(){
        composeAndroidTestRule
            .onNodeWithText("Please choose a square.")
            .assertIsDisplayed()
    }

    @Test
    fun shouldDisplayButtonOnCreation(){
        composeAndroidTestRule
            .onNodeWithTag("Button")
            .assertIsDisplayed()
    }

    @Test
    fun shouldDisplayResetButtonText(){
        composeAndroidTestRule
            .onNodeWithText("Reset")
            .assertIsDisplayed()
    }

    @Test
    fun  shouldCanProperlyClickOnButton(){
        composeAndroidTestRule
            .onNodeWithTag("Button")
            .performClick()
    }

    @Test
    fun shouldDisplayMatrix(){
        composeAndroidTestRule
            .onNodeWithTag("Matrix")
            .assertIsDisplayed()
    }

    @Test
    fun shouldDisplayPleaseChooseASquareOnResetClicked(){
        composeAndroidTestRule
            .onNodeWithTag("Button")
            .performClick()

        composeAndroidTestRule
            .onNodeWithText("Please choose a square.")
            .assertIsDisplayed()
    }

    @Test
    fun shouldDisplaySquareWithTag0(){
        composeAndroidTestRule
            .onNodeWithTag("0")
            .assertIsDisplayed()
    }

    @Test
    fun shouldDisplaySquareWithTag8(){
        composeAndroidTestRule
            .onNodeWithTag("8")
            .assertIsDisplayed()
    }

    @Test
    fun shouldDisplayXWhenClickedOnSquare0(){
        composeAndroidTestRule
            .onNodeWithTag("0")
            .performClick()

        composeAndroidTestRule
            .onNodeWithText(X.text)
            .assertIsDisplayed()
    }

    @Test
    fun shouldDisplayOWhenClickedOnSecondSquare(){
        composeAndroidTestRule
            .onNodeWithTag("0")
            .performClick()

        composeAndroidTestRule
            .onNodeWithTag("1")
            .performClick()

        composeAndroidTestRule
            .onNodeWithText(O.text)
            .assertIsDisplayed()
    }

    @Test
    fun shouldWinInRowWhenXPlaysOnFirstRow(){
        winInRow0()

        composeAndroidTestRule
            .onNodeWithText("${X.name} WON!")
            .assertIsDisplayed()
    }

    @Test
    fun shouldDisableSquareWhenAlreadyClicked() {
        composeAndroidTestRule
            .onNodeWithTag("0")
            .performClick()

        composeAndroidTestRule
            .onNodeWithTag("0")
            .assertIsNotEnabled()
    }

    @Test
    fun shouldDisableAllSquaresOnGameWon(){
        winInRow0()

        composeAndroidTestRule
            .onNodeWithTag("6")
            .assertIsNotEnabled()
    }

    @Test
    fun shouldDisplayDrawAfterNinePlaysAsDraw(){
        composeAndroidTestRule
            .onNodeWithTag("0")
            .performClick()

        composeAndroidTestRule
            .onNodeWithTag("1")
            .performClick()

        composeAndroidTestRule
            .onNodeWithTag("2")
            .performClick()

        composeAndroidTestRule
            .onNodeWithTag("5")
            .performClick()

        composeAndroidTestRule
            .onNodeWithTag("3")
            .performClick()

        composeAndroidTestRule
            .onNodeWithTag("6")
            .performClick()

        composeAndroidTestRule
            .onNodeWithTag("4")
            .performClick()

        composeAndroidTestRule
            .onNodeWithTag("8")
            .performClick()

        composeAndroidTestRule
            .onNodeWithTag("7")
            .performClick()


        composeAndroidTestRule
            .onNodeWithText("DRAW!")
            .assertIsDisplayed()

    }



    private fun winInRow0() {

        composeAndroidTestRule
            .onNodeWithTag("0")
            .performClick()

        composeAndroidTestRule
            .onNodeWithTag("3")
            .performClick()

        composeAndroidTestRule
            .onNodeWithTag("1")
            .performClick()

        composeAndroidTestRule
            .onNodeWithTag("4")
            .performClick()

        composeAndroidTestRule
            .onNodeWithTag("2")
            .performClick()
    }
}