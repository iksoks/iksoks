package com.xo.iksoks.ui.game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Surface
import com.xo.iksoks.ui.theme.IksOksTheme
import com.xo.iksoks.ui.viewmodel.GameViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameActivity : ComponentActivity() {

    val viewModel: GameViewModel by viewModels()

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            IksOksTheme {
                Surface {
                    IksOksGame(viewModel = viewModel)
                }
            }
        }

    }
}
