package br.com.otavio.victor.composetoolkit.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.otavio.victor.composetoolkit.R
import br.com.otavio.victor.composetoolkit.ui.components.ProfileImageItem
import br.com.otavio.victor.composetoolkit.ui.components.ProfileRow
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme

@Composable
fun ProfileRowScreen() {
    ToolKitTheme {
        ProfileRow(
            rowData = listOf(
                ProfileImageItem(R.drawable.code,  R.string.profile_name, 1),
                ProfileImageItem(R.drawable.code,  R.string.profile_name, 2),
                ProfileImageItem(R.drawable.code,  R.string.profile_name, 3),
                ProfileImageItem(R.drawable.code,  R.string.profile_name, 4),
                ProfileImageItem(R.drawable.code,  R.string.profile_name, 5),
                ProfileImageItem(R.drawable.code,  R.string.profile_name, 6),
                ProfileImageItem(R.drawable.code,  R.string.profile_name, 7),
            ),
            modifier = Modifier.padding(8.dp)
        )
    }
}