package br.com.otavio.victor.composetoolkit.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.otavio.victor.composetoolkit.ui.screens.Search.SearcheableTopBarScreen
import br.com.otavio.victor.composetoolkit.ui.screens.Search.ShearchViewModel
import br.com.otavio.victor.composetoolkit.ui.screens.animated.SettingScreenAnimated
import br.com.otavio.victor.composetoolkit.ui.screens.animated.SettingsAnimatedViewModel
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme

@Composable
fun ToolKitApp(modifier: Modifier = Modifier, searchViewModel: ShearchViewModel) {
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
            //LazyColumnMultiItem()
            //ExpandableView(viewModel: SaveableViewModel)
            //SettingScreenAnimated(viewModel = SettingsAnimatedViewModel())
            SearcheableTopBarScreen(searchViewModel)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ToolKitAppLightPreview() {
    ToolKitTheme(useDarkTheme = false) {
        ToolKitApp(searchViewModel = ShearchViewModel())
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ToolKitAppDarkPreview() {
    ToolKitTheme(useDarkTheme = true) {
        ToolKitApp(searchViewModel = ShearchViewModel())
    }
}