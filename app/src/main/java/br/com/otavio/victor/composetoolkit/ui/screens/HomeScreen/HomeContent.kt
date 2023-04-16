package br.com.otavio.victor.composetoolkit.ui.screens.HomeScreen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.otavio.victor.composetoolkit.R
import br.com.otavio.victor.composetoolkit.ui.components.ProfileImageItem
import br.com.otavio.victor.composetoolkit.ui.components.ProfileRow
import br.com.otavio.victor.composetoolkit.ui.screens.GridView.Gridview
import br.com.otavio.victor.composetoolkit.ui.screens.GridView.SimpleCardItem
import br.com.otavio.victor.composetoolkit.ui.screens.Search.SearchTopBar
import br.com.otavio.victor.composetoolkit.ui.screens.Search.SearchableTopBar
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme


// 3) COMO CONTRUIR A TELA DE HOME
@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    rowData: List<ProfileImageItem> = emptyList(),
    gridViewData: List<SimpleCardItem> = emptyList()
) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
    ) {
        SearchTopBar(
            currentSearchText = "",
            onSearchTextChanged = {},
            onShearchDeactivated = {},
            onShearchDispatched = {}
        )
        HomeSection(title = R.string.app_name) {
            ProfileRow(
                rowData = rowData,
                modifier = Modifier.padding(8.dp)
            )
        }
        HomeSection(title = R.string.app_name) {
            Gridview(
                gridViewData = gridViewData,
                modifier = Modifier.padding(
                    8.dp
                )
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun HomeContentPreview() {
    ToolKitTheme {
        HomeContent(
            rowData = listOf(
                ProfileImageItem(R.drawable.code, R.string.profile_name),
                ProfileImageItem(R.drawable.code, R.string.profile_name),
                ProfileImageItem(R.drawable.code, R.string.profile_name),
                ProfileImageItem(R.drawable.code, R.string.profile_name),
                ProfileImageItem(R.drawable.code, R.string.profile_name),
                ProfileImageItem(R.drawable.code, R.string.profile_name),
                ProfileImageItem(R.drawable.code, R.string.profile_name),
            ),
            gridViewData = listOf(
                SimpleCardItem(R.drawable.code, R.string.profile_name, 1),
                SimpleCardItem(R.drawable.code, R.string.profile_name, 2),
                SimpleCardItem(R.drawable.code, R.string.profile_name, 3),
                SimpleCardItem(R.drawable.code, R.string.profile_name, 4),
                SimpleCardItem(R.drawable.code, R.string.profile_name, 5),
                SimpleCardItem(R.drawable.code, R.string.profile_name, 6),
                SimpleCardItem(R.drawable.code, R.string.profile_name, 7),
            )
        )
    }
}