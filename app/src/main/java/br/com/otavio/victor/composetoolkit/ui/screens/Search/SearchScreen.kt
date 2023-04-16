package br.com.otavio.victor.composetoolkit.ui.screens.Search

import android.annotation.SuppressLint
import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import br.com.otavio.victor.composetoolkit.R
import br.com.otavio.victor.composetoolkit.ui.components.DefaultIcon
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitThemeExtended

// 2) COMO CRIAR OS ICONES DE BUSCA PARTINDO DO ICONE PADRÃO
@Composable
fun SearchIcon(action: () -> Unit = {}) {
    // 1) COMO CRIAR UM ICON PADRÃO REUTILIZÁVEL
    DefaultIcon(
        searchIcon = Icons.Filled.Search,
        contentDescription = "Search Icon",
        onIconClickAction = action
    )
}

// 3) COMO CRIAR UM CAMPO DE BUSCA E CONFIGURAR O CAMPO DE TEXTO
@Composable
fun SearchTopBar(
    currentSearchText: String,
    onSearchTextChanged: (String) -> Unit,
    onShearchDeactivated: () -> Unit,
    onShearchDispatched: (String) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = MaterialTheme.colors.primary
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = currentSearchText,
            onValueChange = { onSearchTextChanged(it) },
            placeholder = {
                Text(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    text = "Digite aqui. . .",
                    color = Color.White
                )
            },
            textStyle = TextStyle(fontSize = ToolKitThemeExtended.typography.body1.fontSize),
            singleLine = true,
            leadingIcon = { SearchLeadingIcon() },
            trailingIcon = {
                SearchTrailingIcon {
                    if (currentSearchText.isNotEmpty()) onSearchTextChanged("") else onShearchDeactivated()
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { onShearchDispatched(currentSearchText) }),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = Color.White.copy(alpha = ContentAlpha.medium)
            )
        )
    }
}

// 4) COMO CRIAR O COMPONENTE DE BUSCA USANDO O CAMPO DE BUSCA
@Composable
fun SearchableTopBar(
    isShowingSearchField: Boolean,
    currentSearchText: String,
    onSearchTextChanged: (String) -> Unit,
    onSearchDeactivated: () -> Unit,
    onSearchDispatched: (String) -> Unit,
    onSearchIconClicked: () -> Unit
) {
    when (isShowingSearchField) {
        true -> SearchTopBar(
            currentSearchText = currentSearchText,
            onSearchTextChanged = onSearchTextChanged,
            onShearchDeactivated = onSearchDeactivated,
            onShearchDispatched = onSearchDispatched
        )

        false -> HomeTopBar(
            topBarNameId = R.string.app_name,
            onShearchIconClicked = onSearchIconClicked
        )
    }
}


@Composable
fun HomeTopBar(@StringRes topBarNameId: Int = R.string.empty, onShearchIconClicked: () -> Unit) {
    TopAppBar(
        title = { Text(text = stringResource(id = topBarNameId)) },
        actions = { SearchIcon(action = onShearchIconClicked) }
    )
}

@Composable
fun SearchLeadingIcon(action: () -> Unit = {}) {
    // 1) COMO CRIAR UM ICON PADRÃO REUTILIZÁVEL
    DefaultIcon(
        modifier = Modifier.alpha(ContentAlpha.medium),
        onIconClickAction = action
    )
}

@Composable
fun SearchTrailingIcon(action: () -> Unit = {}) {
    // 1) COMO CRIAR UM ICON PADRÃO REUTILIZÁVEL
    DefaultIcon(
        searchIcon = Icons.Default.Close,
        contentDescription = "Deactivate Search Icon",
        onIconClickAction = action
    )
}

@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun SearcheableTopBarScreen(shearchViewModel: ShearchViewModel){
    val isShowingSearchField by  shearchViewModel.isShowingSearchField
    val currentSearchText by shearchViewModel.currentSearchText

    ToolKitTheme {
        Scaffold(
            topBar = {
                SearchableTopBar(
                    isShowingSearchField = isShowingSearchField,
                    currentSearchText = currentSearchText,
                    onSearchTextChanged = { shearchViewModel.setCurrentSearchText(newText = it)},
                    onSearchDeactivated = { shearchViewModel.showSearchField(show = false) },
                    onSearchDispatched =  { Log.d("SHEARCH_TEST", "Usuário pesquisou por: $it")},
                    onSearchIconClicked = { shearchViewModel.showSearchField(show = true) }
                )
            }
        ) {}
    }
}