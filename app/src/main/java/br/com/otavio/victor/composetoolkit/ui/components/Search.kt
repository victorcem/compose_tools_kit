package br.com.otavio.victor.composetoolkit.ui.components

import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

// 1) COMO CRIAR UM ICON PADRÃO REUTILIZÁVEL
@Composable
fun DefaultIcon(
    modifier: Modifier = Modifier,
    searchIcon: ImageVector = Icons.Default.Search,
    iconColor: Color = Color.White,
    contentDescription: String = "Magnifier Search Icon",
    onIconClickAction: () -> Unit = {}
) {
    IconButton(
        modifier = Modifier,
        onClick =  onIconClickAction
    ) {
        Icon(
            imageVector = searchIcon,
            contentDescription = contentDescription,
            tint = iconColor
        )
    }
}