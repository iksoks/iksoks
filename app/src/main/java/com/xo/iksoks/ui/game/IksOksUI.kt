package com.xo.iksoks.ui.game

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xo.iksoks.domain.Square.*
import com.xo.iksoks.Constants
import com.xo.iksoks.R
import com.xo.iksoks.domain.IksOks
import com.xo.iksoks.domain.Square
import com.xo.iksoks.ui.viewmodel.GameViewModel

@Composable
fun IksOksGame(
    viewModel: GameViewModel,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        val iksOks = remember { viewModel.iksOks }

        Matrix(
            list = iksOks.value.matrix.flatten(),
            gameWon = iksOks.value.gameWon,
        ) { position ->
            viewModel.play(position = position)
        }

        Reset(viewModel)

        Text(
            text = setupMessage(iksOks),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
private fun Reset(
    viewModel: GameViewModel,
) {
    Button(
        modifier = Modifier
            .padding(16.dp)
            .testTag(stringResource(R.string.button)),
        onClick = {
            viewModel.setupMatrix()
        },
    ) {
        Text(text = stringResource(R.string.reset))
    }
}

@Composable
private fun setupMessage(iksOks: MutableState<IksOks>): String {
    return when {
        iksOks.value.gameWon -> stringResource(id = R.string.gameWon, (if (iksOks.value.xPlaying) X.name else O.name))
        iksOks.value.draw -> stringResource(R.string.draw)
        else -> stringResource(R.string.please_choose_square)
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
        modifier = Modifier.testTag(stringResource(R.string.matrix)),
        cells = GridCells.Fixed(Constants.BOARD_SIZE),
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
                    text = (Square.fromInt(list[position]).text),
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = setupColor(Square.fromInt(list[position]))
                )
            }
        }
    }
}

@Composable
private fun setupColor(
    square: Square,
) = when (square) {
    X -> MaterialTheme.colors.secondary
    O -> MaterialTheme.colors.primary
    else -> MaterialTheme.colors.background
}
