package br.com.otavio.victor.composetoolkit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.otavio.victor.composetoolkit.ui.ToolKitApp
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToolKitTheme {
                ToolKitApp()
            }
        }
    }
}