package com.xo.iksoks

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.xo.iksoks.domain.Square
import com.xo.iksoks.ui.game.GameActivity
import org.junit.Rule
import org.junit.Test

class GameActivityTest{

    @get:Rule
    val composeAndroidTestRule = createAndroidComposeRule<GameActivity>()


    @Test
    fun shouldDisplayTextGameWonFalseOnCreation(){
        composeAndroidTestRule
            .onNodeWithText("Game won: false")
            .assertIsDisplayed()
    }

    @Test
    fun shouldAssertTextGameWonTrueDoesNotExist(){
        composeAndroidTestRule
            .onNodeWithText("Game won: true")
            .assertDoesNotExist()
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
    fun shouldDisplayNineSquaresInMatrix(){
        composeAndroidTestRule
            .onAllNodesWithTag("Square")
            .assertCountEquals(9)

    }

    @Test
    fun shouldDisplaySquareWithEmptyText(){
        composeAndroidTestRule
            .onAllNodesWithText(Square.EMPTY.text)
            .assertCountEquals(9)
    }

    @Test
    fun shouldDisplayTextGameWonFalseOnResetClicked(){
        composeAndroidTestRule
            .onNodeWithTag("Button")
            .performClick()

        composeAndroidTestRule
            .onNodeWithText("Game won: false")
            .assertIsDisplayed()
    }



}