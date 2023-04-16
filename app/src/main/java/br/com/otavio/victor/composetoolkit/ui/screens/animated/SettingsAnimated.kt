package br.com.otavio.victor.composetoolkit.ui.screens.animated


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.OutlinedButton
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

// 1) COMO ANIMAR LISTAS
// 2) COMO OBSERVAR AS MUDANCAS QUE VÃO RE-DESENHAR O COMPONENTE
// 3) COMO MODELAR UMA ANIMAçÃO MAIS ELABORADA

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SettingScreenAnimated(viewModel: SettingsAnimatedViewModel) {

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
                    SettingsItemAnimated(item) { viewModel.navigateTo(item.id) }// ação a ser executada
                    Spacer(modifier = Modifier.height(12.dp))
                    if(viewModel.getLastItemId() == item.id && registerId.isNotEmpty()){
                        RegisterId(registerId)
                    }
                }
            }
        } else {
            SettingsEmptyItem()
            if (registerId.isNotEmpty()){
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
                .weight(1F)
        )
        val registerIdText = stringResource(R.string.register_id)
        Spacer(modifier = Modifier.height(8.dp))
        RegisterIdText(registerIdText)
        RegisterIdText(id)
        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
fun SettingsItemAnimated(
    item: ItemAnimated,
    onItemClicked: () -> Unit = {},
) {
    val expanded = remember { mutableStateOf(false) }

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
                painter = painterResource(R.drawable.ic_verified),
                contentDescription = "certified icon", // NÃO FACA ASSIM, TRADUZA OU PASSE POR REFERÊNCIA.
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.Center),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimaryContainer)
            )
        }

        Spacer(modifier = Modifier.width(4.dp))

        Column(modifier = Modifier
            .weight(1F)
            .clickable { onItemClicked() }) {
            Text(
                text = item.title,
                style = ToolKitThemeExtended.typography.h2
            )

            // ANIMACAO SIMPLES
//            AnimatedVisibility(visible = expanded.value) {
//                Column {
//                    Text(
//                        text = item.activated,
//                    )
//                    Text(
//                        text = item.lastLogin,
//                    )
//                }
//            }

            // ANIMACÃO ELABORADA
            AnimatedVisibility(
                visible = expanded.value,
                enter = fadeIn(animationSpec = tween(250)) +
                        expandVertically (
                            animationSpec = tween(500,
                                easing = FastOutLinearInEasing )
                        ),
                exit = fadeOut(animationSpec = tween(250)) +
                        shrinkVertically (
                            animationSpec = tween(500,
                                easing = FastOutSlowInEasing
                            )
                        )
            )
            {
                Column {
                    Text(
                        text = item.activated,
                    )
                    Text(
                        text = item.lastLogin,
                    )
                }
            }
        }
        Box(modifier = Modifier.width(50.dp)) {
            TextButton(
                onClick = { expanded.value = !expanded.value },
                modifier = Modifier.padding(8.dp),
                shape = RoundedCornerShape(2.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                androidx.compose.material.Icon(
                    imageVector = if(expanded.value) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "delete icon", // NÃO FACA ASSIM, TRADUZA OU PASSE POR REFERÊNCIA.
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}

@Composable
fun SettingsEmptyItem() {
    Box(modifier = Modifier.padding(12.dp)) {
        Column(Modifier.background(colorResource(R.color.seed))) {
            Card(
                shape = RoundedCornerShape(0.dp),
                border = BorderStroke(1.dp, colorResource(R.color.seed)),
                modifier = Modifier.padding(start = 6.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth()
                        .background(ToolKitThemeExtended.colors.snowWhite)
                ) {
                    Box {
                        Image(
                            modifier = Modifier
                                .padding(start = 8.dp, top = 20.dp, end = 8.dp, bottom = 20.dp)
                                .align(Alignment.TopCenter),
                            painter = painterResource(R.drawable.ic_warning),
                            contentDescription = null,
                            // ÓTIMO SABER COMO SE FAZ, PARA COLORIR UM SVG EM COMPOSE
                            colorFilter = ColorFilter.tint(color = colorResource(R.color.seed))
                        )
                    }
                    androidx.compose.material.Text(
                        modifier = Modifier
                            .padding(top = 20.dp, bottom = 20.dp, end = 32.dp),
                        text = stringResource(R.string.app_name),
                        style = ToolKitThemeExtended.typography.body1,
                    )
                }
            }
        }
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
            fontSize = 12.sp
        ),
    )
}

@Composable
fun LazyColumnAnimatedScreen(){
    ToolKitTheme {
        val viewModel = SettingsAnimatedViewModel().apply {
            items.value = mutableListOf(
                ItemAnimated(1, "meu Item 1", "Fev. 2023", "Mar. 2023", "ARTATACK"),
                ItemAnimated(2, "meu Item 2 ", "Fev. 2023", "Mar. 2023", "ARTATACK"),
                ItemAnimated(3, "meu Item 3 ", "Fev. 2023", "Mar. 2023", "ARTATACK"),
                ItemAnimated(4, "meu Item 4", "Fev. 2023", "Mar. 2023", "ARTATACK"),
                ItemAnimated(5, "meu Item 5", "Fev. 2023", "Mar. 2023", "ARTATACK"),
                ItemAnimated(6, "meu Item 6", "Fev. 2023", "Mar. 2023", "ARTATACK"),
                ItemAnimated(7, "meu Item 4", "Fev. 2023", "Mar. 2023", "ARTATACK"),
                ItemAnimated(8, "meu Item 5", "Fev. 2023", "Mar. 2023", "ARTATACK"),
                ItemAnimated(9, "meu Item 6", "Fev. 2023", "Mar. 2023", "ARTATACK"),
                ItemAnimated(10, "meu Item 7", "Fev. 2023", "Mar. 2023", "ARTATACK")
            )
            registerId.value = "C123456"
        }
        SettingScreenAnimated(viewModel)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSettingsEmptyItem(){
    ToolKitTheme {
        SettingsEmptyItem()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewEmptySettingsScreen(){
    ToolKitTheme {
        val viewModel = SettingsAnimatedViewModel()
        SettingScreenAnimated(viewModel)
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewDarkSettingsEmptyItem() {
    ToolKitTheme(useDarkTheme = true) {
        SettingsEmptyItem()
    }
}

@Preview
@Composable
fun PreviewDarkEmptySettingsScreen() {
    ToolKitTheme(useDarkTheme = false) {
        val viewModel = SettingsAnimatedViewModel()
        SettingScreenAnimated(viewModel)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSettingsScreen(){
    ToolKitTheme {
        val viewModel = SettingsAnimatedViewModel().apply { 
            items.value = mutableListOf(ItemAnimated(1,"R123456", "Aug. 2022", "Sept. 2022", "AAAAA"))
        }
        SettingScreenAnimated(viewModel = viewModel)
    }
}