package br.com.otavio.victor.composetoolkit.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.otavio.victor.composetoolkit.R
import br.com.otavio.victor.composetoolkit.ui.components.SimpleCard
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme

@Composable
fun SimpleCardScreen() {
    ToolKitTheme {
        SimpleCard(
            drawable = R.drawable.code,
            text = R.string.app_name,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
    }
}