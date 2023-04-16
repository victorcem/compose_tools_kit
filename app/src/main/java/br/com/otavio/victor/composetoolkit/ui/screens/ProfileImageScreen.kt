package br.com.otavio.victor.composetoolkit.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.otavio.victor.composetoolkit.R
import br.com.otavio.victor.composetoolkit.ui.components.ProfileImage
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme

@Composable
fun ProfileImageScreen() {
    ToolKitTheme {
        ProfileImage(
            text = R.string.profile_name,
            drawable = R.drawable.code,
            modifier = Modifier
                .background(Color(R.color.light_tertiary))
                .padding(8.dp)
        )
    }
}
@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2, showSystemUi = true)
@Composable
fun ProfileImagePreview() {
    ToolKitTheme {
        ProfileImageScreen()
    }
}