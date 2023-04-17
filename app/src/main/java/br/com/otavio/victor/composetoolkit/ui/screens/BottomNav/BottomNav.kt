package br.com.otavio.victor.composetoolkit.ui.screens.BottomNav

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.otavio.victor.composetoolkit.R
import br.com.otavio.victor.composetoolkit.ui.screens.HomeScreen.HomeContent
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme

// 1) COMO CRIAR O BOTTOM NAVIGATION
// 2) COMO CRIAR O PREVIEW
// 3) COMO USAR O SCAFFOLD PARA CRIAR TELA

// 1) COMO CRIAR O BOTTOM NAVIGATION
@Composable
fun BottomNav(
    modifier: Modifier = Modifier,
    onHomeClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(id = R.string.app_name))
            },
            selected = true,
            onClick = onHomeClick
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(text = stringResource(id = R.string.profile_name))
            },
            selected = false,
            onClick = onProfileClick
        )
    }
}

// 2) COMO CRIAR O PREVIEW
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun BottomNavPreview() {
    ToolKitTheme {
        Scaffold(
            bottomBar = { BottomNav() }
        ) { padding ->
            HomeContent(Modifier.padding(padding))
        }
    }
}
