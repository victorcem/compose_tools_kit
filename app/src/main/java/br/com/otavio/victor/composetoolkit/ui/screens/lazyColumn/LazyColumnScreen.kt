package br.com.otavio.victor.composetoolkit.ui.screens.lazyColumn

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.otavio.victor.composetoolkit.R
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitThemeExtended

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyColumnScreen(viewModel: LazyColumnViewModel) {

    val items by viewModel.items.collectAsState()
    val registerId by viewModel.registerId.collectAsState()

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 32.dp)
    ) {
        Text(
            text = "Configurações",
            style = ToolKitThemeExtended.typography.h1,
            modifier = Modifier.padding(start = 32.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        if (items.isNotEmpty()) {
            // LINK OFICIAL: https://developer.android.com/jetpack/compose/lists
            LazyColumn {
                stickyHeader {
                    Text(
                        text = "Ativações",
                        style = ToolKitThemeExtended.typography.h1,
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.background)
                            .fillMaxWidth()
                            .padding(start = 32.dp, top = 16.dp, bottom = 16.dp)
                    )
                }
                items(items = items) { item ->
                    LazyColumnItem(item) { viewModel.removeItem(item)}
                    Spacer(modifier = Modifier.height(12.dp))
                    if(viewModel.getLastItemID() == item.id && registerId.isNotEmpty()){
                        RegisterId(id = registerId)
                    }
                }
            }
        } else {
            LazyColumnEmptyItem()
            if(registerId.isNotEmpty()) {
                RegisterId(id = registerId)
            }
        }
    }
}

@Composable
fun RegisterId(
    id: String
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxHeight()
    ) {
        Spacer(
            modifier = Modifier
                .height(12.dp)
                .weight(1f)
        )
        val registerIdText = stringResource(id = R.string.register_id)
        Spacer(modifier = Modifier.height(8.dp))
        RegisterIdText(registerIdText)
        RegisterIdText(id)
        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
fun LazyColumnItem(
    item: Item,
    onItemCliked: () -> Unit = {},
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(12.dp)
                .size(38.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_verified),
                contentDescription = "certified icon",
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.Center),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimaryContainer)
            )
        }

        Spacer(modifier = Modifier.width(4.dp))

        Column(modifier = Modifier.weight(1F)) {
            Text(
                text = item.title,
                style = ToolKitThemeExtended.typography.h2
            )
            Text(
                text = item.activated
            )
            Text(
                text = item.lastLogin
            )
        }

        Box(modifier = Modifier.width(50.dp)) {
            OutlinedButton(
                onClick = { onItemCliked() },
                modifier = Modifier.padding(8.dp),
                shape = RoundedCornerShape(2.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Icon(
                    Icons.Outlined.Delete,
                    contentDescription = "delete icon",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LazyColumnEmptyItem() {
    Box(modifier = Modifier.padding(12.dp)) {
        Column(Modifier.background(colorResource(id = R.color.seed))) {
            Card(
                shape = RoundedCornerShape(0.dp),
                border = BorderStroke(1.dp, colorResource(id = R.color.seed)),
                modifier = Modifier.padding(start = 6.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth()
                        .background(ToolKitThemeExtended.colors.snowWhite)
                ) {
                    Box{
                        Image(
                            modifier = Modifier
                                .padding(start = 8.dp, top = 20.dp, end = 8.dp, bottom = 20.dp)
                                .align(Alignment.TopCenter),
                            painter = painterResource(id = R.drawable.ic_warning),
                            contentDescription = null,
                            // ÓTIMO SABER COMO SE FAZ, PARA COLORIR UM SVG EM COMPOSE
                            colorFilter = ColorFilter.tint(color = colorResource(id = R.color.seed))
                        )
                    }
                    Text(
                        modifier = Modifier
                            .padding(top = 20.dp, bottom = 20.dp, end = 32.dp),
                        text = stringResource(id = R.string.app_name),
                        style = ToolKitThemeExtended.typography.body1,
                    )

                }
            }
        }
    }
}

@Composable
fun LazyColumnMultiItem(){
    ToolKitTheme {
        val viewModel = LazyColumnViewModel().apply {
            items.value = mutableListOf(
                Item(1, "meu Item 1", "Aug. 2022", "Sept. 2022", "AAAAA"),
                Item(2, "meu Item 2 ", "Aug. 2022", "Sept. 2022", "AAAAA"),
                Item(3, "meu Item 3 ", "Aug. 2022", "Sept. 2022", "AAAAA"),
                Item(4, "meu Item 4", "Aug. 2022", "Sept. 2022", "AAAAA"),
                Item(5, "meu Item 5", "Aug. 2022", "Sept. 2022", "AAAAA"),
                Item(6, "meu Item 6", "Aug. 2022", "Sept. 2022", "AAAAA"),
                Item(7, "meu Item 4", "Aug. 2022", "Sept. 2022", "AAAAA"),
                Item(8, "meu Item 5", "Aug. 2022", "Sept. 2022", "AAAAA"),
                Item(9, "meu Item 6", "Aug. 2022", "Sept. 2022", "AAAAA"),
                Item(10, "meu Item 7", "Aug. 2022", "Sept. 2022", "AAAAA")
            )
            registerId.value = "R123456"
        }
        LazyColumnScreen(viewModel = viewModel)
    }
}

@Composable
private fun RegisterIdText(textString: String) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        text = textString,
        style = ToolKitThemeExtended.typography.body2.copy(
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 12.sp,
        )
    )
}

@Preview
@Composable
fun LazyColumnEmptyItemPreview() {
    ToolKitTheme {
        LazyColumnEmptyItem()
    }
}

@Preview
@Composable
fun EmptyLazyColumnScreenPreview() {
    ToolKitTheme {
        val viewModel = LazyColumnViewModel()
        LazyColumnScreen(viewModel)
    }
}

@Preview
@Composable
fun LazyColumnEmptyItemDarkPreview() {
    ToolKitTheme(useDarkTheme = true) {
        LazyColumnEmptyItem()
    }
}

@Preview
@Composable
fun LazyColumnEmptyItemLightPreview() {
    ToolKitTheme(useDarkTheme = false) {
        LazyColumnEmptyItem()
    }
}

@Preview
@Composable
fun EmptyLazyColumnScreenDarkPreview() {
    ToolKitTheme(useDarkTheme = false) {
        val viewModel = LazyColumnViewModel()
        LazyColumnScreen(viewModel)
    }
}

@Preview
@Composable
fun LazyColumnScreenPreview() {
    ToolKitTheme {
        val viewModel = LazyColumnViewModel().apply {
            items.value = mutableListOf(Item(1,"R123456", "Aug. 2022", "Sept. 2022", "AAAAA"))
        }
        LazyColumnScreen(viewModel)
    }
}

@Preview
@Composable
fun MultiItemsLazyColumnScreenPreview() {
    ToolKitTheme {
        val viewModel = LazyColumnViewModel().apply {
            items.value = mutableListOf(
                Item(1, "Meu Item", "Aug. 2022", "Sept. 2022", "AAAAA"),
                Item(2,"Meu Item", "Aug. 2022", "Sept. 2022", "AAAAA"),
                Item(3,"Meu Item", "Aug. 2022", "Sept. 2022", "AAAAA")
            )
        }
        LazyColumnScreen(viewModel)
    }
}

@Preview
@Composable
fun LazyColumnScreenDarkPreview() {
    ToolKitTheme(useDarkTheme = true) {
        val viewModel = LazyColumnViewModel().apply {
            items.value = mutableListOf(Item(1,"Meu Item", "Aug. 2022", "Sept. 2022", "AAAAA"))
        }
        LazyColumnScreen(viewModel)
    }
}

@Preview
@Composable
fun MultiItemsLazyColumnScreenDarkPreview() {
    ToolKitTheme(useDarkTheme = true) {
        val viewModel = LazyColumnViewModel().apply {
            items.value = mutableListOf(
                Item(1,"Meu Item", "Aug. 2022", "Sept. 2022", "AAAAA"),
                Item(2,"Meu Item", "Aug. 2022", "Sept. 2022", "AAAAA"),
                Item(3,"Meu Item", "Aug. 2022", "Sept. 2022", "AAAAA")
            )
        }
        LazyColumnScreen(viewModel)
    }
}
