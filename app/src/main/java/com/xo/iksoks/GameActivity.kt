package com.xo.iksoks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.xo.iksoks.Constants.BOARD_SIZE
import com.xo.iksoks.ui.theme.IksOksTheme


class GameActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val game = IksOks().apply { setup() }

        setContent {
            IksOksTheme {
                Surface {
                    val iksOks = remember { game }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        val list = remember { iksOks.matrix.flatten() }

                        LazyVerticalGrid(
                            modifier = Modifier.testTag("Matrix"),
                            cells = GridCells.Fixed(BOARD_SIZE),
                            contentPadding = PaddingValues(
                                start = 12.dp,
                                top = 16.dp,
                                end = 12.dp,
                                bottom = 16.dp,
                            ),
                        ) {
                            items(list.size) { position ->
                                Button(
                                    modifier = Modifier.testTag("Square"),
                                    onClick = {},
                                ) {
                                    Text(text = position.toString())
                                }
                            }
                        }

                        Button(
                            modifier = Modifier
                                .padding(16.dp)
                                .testTag("Button"),
                            onClick = {},
                        ) {
                            Text(text = "Reset")
                        }

                        Text(
                            text = "Game won: ${iksOks.gameWon}",
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}
