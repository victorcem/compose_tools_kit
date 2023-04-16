package br.com.otavio.victor.composetoolkit.ui.screens.HomeScreen

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.otavio.victor.composetoolkit.R
import br.com.otavio.victor.composetoolkit.ui.components.ProfileImageItem
import br.com.otavio.victor.composetoolkit.ui.components.ProfileRow
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme

// 1) COMO CRIAR SEçÕES PARA REUSAR NAS COMPOSIçÕES
// 2) COMO CRIAR O PREVIEW
// 3) COMO CONTRUIR A TELA DE HOME
// 4) COMO USAR ISSO NA PRÁTICA

// 1) COMO CRIAR SEçÕES PARA REUSAR NAS COMPOSIçÕES
@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            modifier = Modifier.padding(top = 8.dp, start = 12.dp),
            text = stringResource(id = title)
        )
        content()
    }
}

// 2) COMO CRIAR O PREVIEW
@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun HomeSectionPreview(){
    ToolKitTheme {
        HomeSection(R.string.app_name) {
            ProfileRow(
                rowData = listOf(
                    ProfileImageItem(R.drawable.ic_droid, R.string.profile_name),
                    ProfileImageItem(R.drawable.ic_droid, R.string.profile_name),
                    ProfileImageItem(R.drawable.ic_droid, R.string.profile_name),
                    ProfileImageItem(R.drawable.ic_droid, R.string.profile_name),
                    ProfileImageItem(R.drawable.ic_droid, R.string.profile_name),
                    ProfileImageItem(R.drawable.ic_droid, R.string.profile_name),
                    ProfileImageItem(R.drawable.ic_droid, R.string.profile_name),
                ),
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}