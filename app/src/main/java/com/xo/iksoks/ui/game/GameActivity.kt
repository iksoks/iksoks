package com.xo.iksoks.ui.game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xo.iksoks.Constants.BOARD_SIZE
import com.xo.iksoks.domain.IksOks
import com.xo.iksoks.domain.Square.*
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

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        val iksOks = remember { viewModel.iksOks }

                        Matrix(
                            list = iksOks.value.matrix.flatten(),
                            gameWon = iksOks.value.gameWon,
                        ) { position ->
                            viewModel.play(position = position)
                        }

                        Button(
                            modifier = Modifier
                                .padding(16.dp)
                                .testTag("Button"),
                            onClick = {
                                viewModel.setupMatrix()
                            },
                        ) {
                            Text(text = "Reset")
                        }

                        Text(
                            text = setupMessage(iksOks),
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }

    @Composable
    private fun setupMessage(iksOks: MutableState<IksOks>) =
        when {
            iksOks.value.gameWon -> (if (iksOks.value.xPlaying) X.name else O.name) + " WON!"
            iksOks.value.draw -> "DRAW!"
            else -> "Please choose a square."
        }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Matrix(
    list: List<Int>,
    gameWon: Boolean,
    onClick: (Int) -> Unit,
) {
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
                modifier = Modifier
                    .testTag(position.toString())
                    .padding(4.dp)
                    .aspectRatio(1f),
                onClick = {
                    onClick(position)
                },
                enabled = list[position] == EMPTY.value && !gameWon,
            ) {
                Text(
                    text = setupSquareText(list, position),
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                )
            }
        }
    }
}

@Composable
private fun setupSquareText(
    list: List<Int>,
    position: Int,
) = when (list[position]) {
    X.value -> X.text
    O.value -> O.text
    else -> EMPTY.text
}.toString()
