package br.com.otavio.victor.composetoolkit.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import br.com.otavio.victor.composetoolkit.ui.navigation.RootNavigationGraph
import br.com.otavio.victor.composetoolkit.ui.screens.ColumnRowsBoxes
import br.com.otavio.victor.composetoolkit.ui.screens.lazyColumn.LazyColumnMultiItem
import br.com.otavio.victor.composetoolkit.ui.screens.observeState.LoadingView
import br.com.otavio.victor.composetoolkit.ui.screens.observeState.LoadingViewModel
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme

@Composable
fun ToolKitApp(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colorScheme.background
        ) {
            //ColumnRowsBoxes(LocalContext.current)
            //LoadingView(viewModel = viewModel())
            //RootNavigationGraph(navController = rememberNavController())
            LazyColumnMultiItem()
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ToolKitAppLightPreview() {
    ToolKitTheme(useDarkTheme = false) {
        ToolKitApp()
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ToolKitAppDarkPreview() {
    ToolKitTheme(useDarkTheme = true) {
        ToolKitApp()
    }
}