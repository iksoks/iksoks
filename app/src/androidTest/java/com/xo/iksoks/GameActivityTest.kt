package com.xo.iksoks

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class GameActivityTest{

    @get:Rule
    val composeAndroidTestRule = createAndroidComposeRule<GameActivity>()


    @Test
    fun shouldDisplayTextGameWonFalseOnCreation(){
        composeAndroidTestRule
            .onNodeWithText("Game won: false")
            .assertExists()
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
            .assertDoesNotExist()
    }

}