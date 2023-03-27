package br.com.otavio.victor.composetoolkit.ui.screens.observeState

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.otavio.victor.composetoolkit.R
import br.com.otavio.victor.composetoolkit.ui.components.ToolKitButton
import br.com.otavio.victor.composetoolkit.ui.components.ToolKitCircularProgressIndicator
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitThemeExtended

@Composable
fun LoadingView(viewModel: LoadingViewModel) {

    val loading by viewModel.loadingStateFlow.collectAsState()

    when {
        loading -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                ToolKitCircularProgressIndicator(Modifier, R.string.loading)
                ToolKitButton(
                    modifier = Modifier,
                    clickAction = { viewModel.setLodingState(false) },
                    textId = R.string.exit_loading
                )
            }
        }
        else -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "AEEEEEEEE! Carreguei!!",
                    style = ToolKitThemeExtended.typography.h1
                )
                ToolKitButton(
                    modifier = Modifier,
                    clickAction = { viewModel.setLodingState(true) },
                    textId = R.string.enter_loading
                )
            }
        }
    }
}

@Preview
@Composable
fun LoadingViewLightPreview() {
    ToolKitTheme(useDarkTheme = false) {
        LoadingView(LoadingViewModel().apply {
            loadingStateFlow.value = true
        })
    }
}

@Preview
@Composable
fun LoadingViewDarkPreview() {
    ToolKitTheme(useDarkTheme = true) {
        LoadingView(LoadingViewModel().apply {
            loadingStateFlow.value = true
        })
    }
}