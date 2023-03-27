package br.com.otavio.victor.composetoolkit.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.otavio.victor.composetoolkit.R
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme

@Composable
fun ToolKitIconImage(
    @DrawableRes iconLightId: Int,
    iconColor: Color = MaterialTheme.colorScheme.primary,
    backgroundColor: Color = MaterialTheme.colorScheme.onBackground,
    onCLick: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .padding(12.dp)
            .size(38.dp)
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable { onCLick() }
    ) {
        Image(
            painter = painterResource(id = iconLightId),
            contentDescription = "",
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.Center)
                .clickable { onCLick() },
            colorFilter = ColorFilter.tint(
                iconColor
            )
        )
    }
}

@Preview
@Composable
fun IconImageLightPreview() {
    ToolKitTheme(useDarkTheme = false) {
        ToolKitIconImage(
            R.drawable.ic_airplanemode,
        )
    }
}

@Preview
@Composable
fun IconImageDarkPreview() {
    ToolKitTheme(useDarkTheme = true) {
        ToolKitIconImage(
            R.drawable.ic_airplanemode,
        )
    }
}