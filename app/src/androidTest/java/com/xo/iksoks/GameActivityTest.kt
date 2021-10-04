package com.xo.iksoks

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
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


}