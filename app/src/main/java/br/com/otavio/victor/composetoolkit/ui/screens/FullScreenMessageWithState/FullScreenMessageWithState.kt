package br.com.otavio.victor.composetoolkit.ui.screens.FullScreenMessageWithState

import android.content.res.Configuration
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.otavio.victor.composetoolkit.R
import br.com.otavio.victor.composetoolkit.ui.components.BottomButton
import br.com.otavio.victor.composetoolkit.ui.components.TopButton
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitThemeExtended

// COMO CRIAR UM DETENTOR DE ESTADOS
// COMO LEMBRAR DO ESTADO DENTRO DO COMPOSABLE

@Composable
fun FullScreenMessageWithState(
    @DrawableRes icon: Int? = null,
    @ColorRes iconTint: Int? = null,
    title: String,
    message: String,
    topButtonText: String? = null,
    topButtonAction: () -> Unit = {},
    bottomButtonText: String,
    bottomButtonAction: () -> Unit = {}
) {
    val state by remember {
        mutableStateOf(
            MessageState(
                icon = icon,
                iconTint = iconTint,
                title = title,
                message = message,
            )
        )
    }

    Surface {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxHeight()
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
                state.icon?.let {
                    Image(
                        modifier = Modifier
                            .width(70.dp)
                            .height(70.dp),
                        painter = painterResource(id = it),
                        contentDescription = "",
                        colorFilter = if (state.iconTint != null) ColorFilter.tint(colorResource(id = state.iconTint!!)) else null
                    )
                }

                Text(
                    text = state.title,
                    style = ToolKitThemeExtended.typography.h1,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = state.message,
                    style = ToolKitThemeExtended.typography.body1,
                    modifier = Modifier.padding(top = 16.dp, bottom = 36.dp),
                    textAlign = TextAlign.Center
                )
            }

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                if (topButtonText != null) {
                    TopButton(
                        modifier = Modifier.fillMaxWidth(),
                        text = topButtonText,
                        onClick = topButtonAction
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                BottomButton(
                    Modifier.fillMaxWidth(),
                    text = bottomButtonText,
                    onClick = bottomButtonAction
                )
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FullscreenMsgWithStatePreview() {
    ToolKitTheme {
        FullScreenMessageWithState(
            icon = R.drawable.ic_error_generic,
            title = "Title",
            message = "Message",
            topButtonText = "Cancel",
            bottomButtonText = "OK"
        )
    }
}