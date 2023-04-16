package br.com.otavio.victor.composetoolkit.ui.screens.HomeScreen

import androidx.compose.runtime.Composable
import br.com.otavio.victor.composetoolkit.R
import br.com.otavio.victor.composetoolkit.ui.components.ProfileImageItem
import br.com.otavio.victor.composetoolkit.ui.screens.GridView.SimpleCardItem
import br.com.otavio.victor.composetoolkit.ui.screens.Search.SearchTopBar
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme

// 4) COMO USAR ISSO NA PRÁTICA
@Composable
fun HomeScreen(){
    ToolKitTheme {
        HomeContent(
            rowData = listOf(
                ProfileImageItem(R.drawable.code, R.string.profile_name, 1),
                ProfileImageItem(R.drawable.code, R.string.profile_name, 2),
                ProfileImageItem(R.drawable.code, R.string.profile_name, 3),
                ProfileImageItem(R.drawable.code, R.string.profile_name, 4),
                ProfileImageItem(R.drawable.code, R.string.profile_name, 5),
                ProfileImageItem(R.drawable.code, R.string.profile_name, 6),
                ProfileImageItem(R.drawable.code, R.string.profile_name, 7),
                ProfileImageItem(R.drawable.code, R.string.profile_name, 8)
            ),
            gridViewData = listOf(
                SimpleCardItem(R.drawable.ic_droid, R.string.profile_name, 1),
                SimpleCardItem(R.drawable.ic_droid, R.string.profile_name, 2),
                SimpleCardItem(R.drawable.ic_droid, R.string.profile_name, 3),
                SimpleCardItem(R.drawable.ic_droid, R.string.profile_name, 4),
                SimpleCardItem(R.drawable.ic_droid, R.string.profile_name, 5),
                SimpleCardItem(R.drawable.ic_droid, R.string.profile_name, 6),
                SimpleCardItem(R.drawable.ic_droid, R.string.profile_name, 7),
                SimpleCardItem(R.drawable.ic_droid, R.string.profile_name, 8)
            )
        )
    }
}