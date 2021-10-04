package com.xo.iksoks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.xo.iksoks.ui.theme.IksOksTheme

class GameActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val game = IksOks().apply { setup() }

        setContent {
            IksOksTheme {
                Surface {
                    val iksOks = remember { game }
                    Text(
                        text = "Game won: ${iksOks.gameWon}",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}
