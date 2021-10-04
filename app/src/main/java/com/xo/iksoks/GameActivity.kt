package com.xo.iksoks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.xo.iksoks.ui.theme.IksOksTheme

class GameActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IksOksTheme {
                //Todo Setup UI
            }
        }
    }
}
