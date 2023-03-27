package br.com.otavio.victor.composetoolkit.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.otavio.victor.composetoolkit.R
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme

@Composable
fun ToolKitButton(
    modifier: Modifier,
    clickAction: () -> Unit,
    @StringRes textId: Int,
) {
    Button(
        modifier = modifier,
        onClick = clickAction
    ) {
        Text(text = stringResource(id = textId))
    }
}

@Composable
fun ToolKitButtonRow(
    modifier: Modifier,
    positiveAction: (() -> Unit)? = null,
    neutralAction: (() -> Unit)? = null,
    negativeAction: (() -> Unit)? = null,
    @StringRes positiveTextId: Int? = null,
    @StringRes neutralTextId: Int? = null,
    @StringRes negativeTextId: Int? = null,
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        positiveAction?.let { clickAction ->
            positiveTextId?.let { textId ->
                ToolKitButton(modifier, clickAction, textId)
            }
        }
        if(positiveAction == null) Spacer(modifier = modifier)

        neutralAction?.let { clickAction ->
            neutralTextId?.let{ textId ->
                ToolKitButton(modifier, clickAction, textId)
            }
        }
        if(neutralAction == null) Spacer(modifier = modifier)

        negativeAction?.let { clickAction ->
            negativeTextId?.let { textId ->
                ToolKitButton(modifier, clickAction, textId)
            }
        }
        if (negativeAction == null) Spacer(modifier = modifier)

    }
}

@Preview
@Composable
fun ArsenalButtonLightPreview() {
    ToolKitTheme(useDarkTheme = false) {
       ToolKitButton(
            modifier = Modifier.widthIn(min = 100.dp, max = 120.dp),
            {},
           R.string.btn_template_name
        )
    }
}

@Preview
@Composable
fun ToolKitButtonLightPreview() {
    ToolKitTheme(useDarkTheme = true) {
        ToolKitButton(
            modifier = Modifier.widthIn(min = 100.dp, max = 120.dp),
            {},
            R.string.btn_template_name
        )
    }
}

@Preview
@Composable
fun ToolKitButtonDarkPreview() {
    ToolKitTheme(useDarkTheme = false) {
        ToolKitButtonRow(
            modifier = Modifier.widthIn(min = 100.dp, max = 120.dp),
            positiveAction = {},
            positiveTextId = R.string.btn_template_name,
            neutralAction = {},
            neutralTextId = R.string.btn_template_name,
            negativeAction = {},
            negativeTextId = R.string.btn_template_name
        )
    }
}

@Preview
@Composable
fun ArsenalButtonRowDarkPreview() {
    ToolKitTheme(useDarkTheme = true) {
        ToolKitButtonRow(
            modifier = Modifier.widthIn(min = 100.dp, max = 120.dp),
            positiveAction = {},
            positiveTextId = R.string.btn_template_name,
            neutralAction = {},
            neutralTextId = R.string.btn_template_name,
            negativeAction = {},
            negativeTextId = R.string.btn_template_name
        )
    }
}