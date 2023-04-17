package br.com.otavio.victor.composetoolkit.ui.screens.BottomNav

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.otavio.victor.composetoolkit.R
import br.com.otavio.victor.composetoolkit.ui.components.ProfileImageItem
import br.com.otavio.victor.composetoolkit.ui.screens.GridView.SimpleCardItem
import br.com.otavio.victor.composetoolkit.ui.screens.HomeScreen.HomeContent
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme

// 3) COMO USAR O SCAFFOLD PARA CRIAR TELA
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavScreen(){
    ToolKitTheme {
        Scaffold(bottomBar = { BottomNav() }) {padding ->
            HomeContent(
                modifier = Modifier.padding(padding),
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
}