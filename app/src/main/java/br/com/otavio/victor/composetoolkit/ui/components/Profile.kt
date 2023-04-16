package br.com.otavio.victor.composetoolkit.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.otavio.victor.composetoolkit.R
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitThemeExtended

// 1) COMO CRIAR UM COMPONENTE DE AVATAR REUTILIZÁVEL
// 2) COMO CRIAR UM PREVIEW CUSTOMIZADO
@Composable
fun ProfileImage(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    action: () -> Unit = {}
) {
    Column(
        modifier = modifier.clickable { action() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(88.dp).clip(CircleShape)
        )
        Text(
            text = stringResource(text),
            style = ToolKitThemeExtended.typography.h2,
            modifier = Modifier.paddingFromBaseline(
                top = 24.dp, bottom = 8.dp
            )
        )
    }
}

// COMO EXIBIR BACKGROUND NO PREVIEW
@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2, showSystemUi = true)
@Composable
fun ProfileImagePreview() {
    ToolKitTheme {
        ProfileImage(
            drawable = R.drawable.ic_droid,
            text = R.string.app_name,
            modifier = Modifier.padding(8.dp)
        )
    }
}