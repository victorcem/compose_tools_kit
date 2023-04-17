package br.com.otavio.victor.composetoolkit.ui.screens.FullScreenMessage

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.otavio.victor.composetoolkit.ui.components.BottomButton
import br.com.otavio.victor.composetoolkit.ui.components.TopButton
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitThemeExtended

// COMO CRIAR UM DIALOG FULL SCREEN REUTILIZÁVEL
// COMO CUSTOMIZAR ICONS, CORES
// COMO DEIXAR O DIALOG MULTI-USO

@Composable
fun FullScreenMessage(
    @DrawableRes icon: Int? = null,
    @ColorRes iconTint: Int? = null,
    title: String,
    message: String,
    topButtonText: String? = null,
    topButtonAction: () -> Unit = {},
    bottomButtonText: String,
    bottomButtonAction: () -> Unit = {}
) {

    Surface {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxHeight(),
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(state = rememberScrollState())
                    .weight(weight = 1f, fill = true)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                icon?.let {
                    Image(
                        modifier = Modifier.width(70.dp).height(70.dp),
                        painter = painterResource(it),
                        contentDescription = "",
                        colorFilter = if (iconTint!= null) ColorFilter.tint(colorResource(iconTint)) else null
                    )
                }

                Text(
                    text = title,
                    style = ToolKitThemeExtended.typography.h1,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = message,
                    style = ToolKitThemeExtended.typography.body1,
                    modifier = Modifier.padding(top = 16.dp, bottom = 36.dp),
                    textAlign = TextAlign.Center
                )
            }

            Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
                if (topButtonText != null) {
                    TopButton(Modifier.fillMaxWidth(), text = topButtonText, onClick = topButtonAction)
                }
                Spacer(Modifier.height(4.dp))

                BottomButton(Modifier.fillMaxWidth(), text = bottomButtonText, onClick = bottomButtonAction)
            }
        }
    }
}
