package br.com.otavio.victor.composetoolkit.ui.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.otavio.victor.composetoolkit.R
import br.com.otavio.victor.composetoolkit.ui.components.ToolKitButtonRow
import br.com.otavio.victor.composetoolkit.ui.components.ToolKitIconImage
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitThemeExtended

// 1) Como estruturar componente (antes de começar) Criar view
// 2) Como usar Column, Rows, Boxes - Criar componentes
// 3) Como deixar seus componentes reusáveis
@Composable
fun ColumnRowsBoxes(context: Context) {
    val action = { Toast.makeText(context, "Fui clicado aqui!", Toast.LENGTH_SHORT).show() }
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .weight(weight = 1f)
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
        ) {
            Text(
                text = "Compose Tool Kit",
                style = ToolKitThemeExtended.typography.h1
            )

            Text(
                text = "Que a força está com você!!",
                style = ToolKitThemeExtended.typography.body1,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            ToolKitIconImage(iconLightId = R.drawable.ic_airplanemode)
        }

        ToolKitButtonRow(
            modifier = Modifier
                .widthIn(
                    min = 100.dp,
                    max = 120.dp
                ),
            positiveAction = action,
            positiveTextId = R.string.btn_row_confirm,
            neutralAction = action,
            negativeTextId = R.string.btn_row_maybe,
            negativeAction = action,
            neutralTextId = R.string.btn_row_cancel,

        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ColumnRowsBoxesLightPreview() {
    ToolKitTheme(useDarkTheme = false) {
        ColumnRowsBoxes(LocalContext.current)
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ColumnRowsBoxesDarkPreview() {
    ToolKitTheme(useDarkTheme = true) {
        ColumnRowsBoxes(LocalContext.current)
    }
}