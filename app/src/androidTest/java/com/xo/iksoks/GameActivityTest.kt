package com.xo.iksoks

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.xo.iksoks.ui.game.GameActivity
import com.xo.iksoks.domain.Square.*
import org.junit.Rule
import org.junit.Test

class GameActivityTest {

    @get:Rule
    val composeAndroidTestRule = createAndroidComposeRule<GameActivity>()


    @Test
    fun shouldDisplayTextPleaseChooseASquareOnCreation() {
        composeAndroidTestRule.apply {
            onNodeWithText(activity.getString(R.string.please_choose_square))
                .assertIsDisplayed()
        }
    }

    @Test
    fun shouldDisplayButtonOnCreation() {
        composeAndroidTestRule.apply {
            onNodeWithTag(activity.getString(R.string.button))
                .assertIsDisplayed()
        }
    }

    @Test
    fun shouldDisplayResetButtonText() {
        composeAndroidTestRule.apply {
            onNodeWithText(activity.getString(R.string.reset))
                .assertIsDisplayed()
        }
    }

    @Test
    fun shouldCanProperlyClickOnButton() {
        composeAndroidTestRule.apply {
            onNodeWithTag(activity.getString(R.string.button))
                .performClick()
        }
    }

    @Test
    fun shouldDisplayMatrix() {
        composeAndroidTestRule.apply {
            onNodeWithTag(activity.getString(R.string.matrix))
                .assertIsDisplayed()
        }
    }

    @Test
    fun shouldDisplayPleaseChooseASquareOnResetClicked() {
        composeAndroidTestRule.apply {
            onNodeWithTag(activity.getString(R.string.button))
                .performClick()

            onNodeWithText(activity.getString(R.string.please_choose_square))
                .assertIsDisplayed()
        }
    }

    @Test
    fun shouldDisplaySquareWithTag0() {
        composeAndroidTestRule
            .onNodeWithTag("0")
            .assertIsDisplayed()
    }

    @Test
    fun shouldDisplaySquareWithTag8() {
        composeAndroidTestRule
            .onNodeWithTag("8")
            .assertIsDisplayed()
    }

    @Test
    fun shouldDisplayXWhenClickedOnSquare0() {
        composeAndroidTestRule.apply {
            onNodeWithTag("0")
                .performClick()

            onNodeWithText(X.text)
                .assertIsDisplayed()
        }
    }

    @Test
    fun shouldDisplayOWhenClickedOnSecondSquare() {
        composeAndroidTestRule.apply {

            onNodeWithTag("0")
                .performClick()

            onNodeWithTag("1")
                .performClick()

            onNodeWithText(O.text)
                .assertIsDisplayed()
        }
    }

    @Test
    fun shouldWinInRowWhenXPlaysOnFirstRow() {
        winInRow0()

        composeAndroidTestRule.apply {
            onNodeWithText(activity.getString(R.string.gameWon, X.text))
                .assertIsDisplayed()
        }
    }

    @Test
    fun shouldDisableSquareWhenAlreadyClicked() {
        composeAndroidTestRule.apply {
            onNodeWithTag("0")
                .performClick()

            onNodeWithTag("0")
                .assertIsNotEnabled()
        }
    }

    @Test
    fun shouldDisableAllSquaresOnGameWon() {
        winInRow0()

        composeAndroidTestRule
            .onNodeWithTag("6")
            .assertIsNotEnabled()
    }

    @Test
    fun shouldDisplayDrawAfterNinePlaysAsDraw() {
        composeAndroidTestRule.apply {

            onNodeWithTag("0")
                .performClick()

            onNodeWithTag("1")
                .performClick()

            onNodeWithTag("2")
                .performClick()

            onNodeWithTag("5")
                .performClick()

            onNodeWithTag("3")
                .performClick()

            onNodeWithTag("6")
                .performClick()

            onNodeWithTag("4")
                .performClick()

            onNodeWithTag("8")
                .performClick()

            onNodeWithTag("7")
                .performClick()


            onNodeWithText(activity.getString(R.string.draw))
                .assertIsDisplayed()
        }
    }

    private fun winInRow0() {

        composeAndroidTestRule.apply {

            onNodeWithTag("0")
                .performClick()

            onNodeWithTag("3")
                .performClick()

            onNodeWithTag("1")
                .performClick()

            onNodeWithTag("4")
                .performClick()

            onNodeWithTag("2")
                .performClick()
        }
    }

}


