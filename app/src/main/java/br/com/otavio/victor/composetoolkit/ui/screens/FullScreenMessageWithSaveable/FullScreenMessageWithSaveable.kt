package br.com.otavio.victor.composetoolkit.ui.screens.FullScreenMessageWithSaveable

import android.content.res.Configuration
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable
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
import br.com.otavio.victor.composetoolkit.ui.screens.FullScreenMessageWithState.FullScreenMessageWithState
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitThemeExtended

@Composable
fun FullScreenMessageWithSaveable(
    @DrawableRes icon: Int? = null,
    @ColorRes iconTint: Int? = null,
    title: String,
    message: String,
    topButtonText: String? = null,
    topButtonAction: () -> Unit = {},
    bottomButtonText: String,
    bottomButtonAction: () -> Unit = {}
) {

    // https://developer.android.com/jetpack/compose/state
    val state = rememberSaveable(saver = MessageStateSaver) {
        MessageStateSaveable(
            icon = icon,
            iconTint = iconTint,
            title = title,
            message = message
        )
    }

    Surface {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
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

            Column(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()) {
                if(topButtonText != null) {
                    TopButton(Modifier.fillMaxWidth(), text = topButtonText, onClick = topButtonAction)
                }
                Spacer(modifier = Modifier.height(4.dp))

                BottomButton(modifier = Modifier.fillMaxWidth(), text = bottomButtonText, onClick = bottomButtonAction)
            }
        }
    }
}

private val MessageStateSaver = run {
    val icon = "icon"
    val iconTint = "iconTint"
    val title = "title"
    val message = "message"

    mapSaver(
        save = { state: MessageStateSaveable ->
            mapOf(
                icon to state.icon,
                iconTint to state.iconTint,
                title to state.title,
                message to state.message
            )
        },
        restore = { restorationMap: Map<String, Any?> ->
            MessageStateSaveable(
                icon = restorationMap[icon] as Int?,
                iconTint = restorationMap[iconTint] as Int?,
                title = restorationMap[title] as String,
                message = restorationMap[message] as String
            )
        }
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun FullScreenMessageWithSavablePreview() {
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