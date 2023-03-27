package br.com.otavio.victor.composetoolkit.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.otavio.victor.composetoolkit.R
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme

@Composable
fun ToolKitCircularProgressIndicator(
    modifier: Modifier,
    @StringRes progressTextId: Int = R.string.loading,
    progressTextStyle: TextStyle = LocalTextStyle.current,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.padding(top = 12.dp))
        CircularProgressIndicator()
        Text(
            modifier = modifier,
            text = stringResource(id = progressTextId),
            style = progressTextStyle,
        )
        Spacer(modifier = Modifier.padding(bottom = 12.dp))
    }
}

@Preview
@Composable
fun ToolKitCircularProgressIndicatorLightPreview(){
    ToolKitTheme(useDarkTheme = false) {
      ToolKitCircularProgressIndicator(Modifier)
    }
}
@Preview
@Composable
fun ToolKitCircularProgressIndicatorDarkPreview(){
    ToolKitTheme(useDarkTheme = true) {
      ToolKitCircularProgressIndicator(Modifier)
    }
}
