package br.com.otavio.victor.composetoolkit.ui.screens.SplashScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.otavio.victor.composetoolkit.ui.screens.LandingScreen
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme

@Composable
fun SplashScreen() {
    ToolKitTheme {
        Surface(color = MaterialTheme.colorScheme.primary) {
            var showLandingSreen by remember { mutableStateOf(true) }
            if (showLandingSreen) {
                LandingScreen(
                    modifier = Modifier,
                    splashWaitTime = 1_500L,
                    onTimeout = { showLandingSreen = false }
                )
            } else {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Tela de Home")
                }
            }
        }
    }
}
