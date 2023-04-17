package br.com.otavio.victor.composetoolkit.ui.screens.DrawerMenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.otavio.victor.composetoolkit.R
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme

@Composable
fun FakeContent(modifier: Modifier = Modifier, onClick: () -> Unit = {}) {

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Button(
            onClick = onClick
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(RoundedCornerShape(4.dp)), painter = painterResource(
                        id = R.drawable.code
                    ), contentDescription = null
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = "Click Me!", color = MaterialTheme.colorScheme.onPrimary)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FakeContentLightPreview() {
    ToolKitTheme {
        FakeContent()
    }
}
