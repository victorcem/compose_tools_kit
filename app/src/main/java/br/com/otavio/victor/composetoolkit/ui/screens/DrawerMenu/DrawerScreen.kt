package br.com.otavio.victor.composetoolkit.ui.screens.DrawerMenu

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme
import kotlinx.coroutines.launch

@Composable
fun DrawerScreen() {
    ToolKitTheme {
        val scaffoldState = rememberScaffoldState()
        Scaffold(
            scaffoldState = scaffoldState,
            modifier = Modifier.statusBarsPadding(),
            drawerContent = {Drawer(onclick = ::showSelection)}
        ) { padding ->
            val scope = rememberCoroutineScope()
            FakeContent(
                modifier = Modifier.padding(padding),
                onClick = {
                    scope.launch {
                        // suspended function fora do escopo desse composable (no escopo do Scaffold)
                        // mas que DESENHA também! Não podemos usar LaunchedEffect como antes porque
                        // não podemos chamar elementos de composição em openDrawer. Não estamos na composição.
                        scaffoldState.drawerState.open()
                    }
                }
            )

        }
    }
}

private fun showSelection(context: Context, selectionId: Int) {
    Toast.makeText(context, "Cliquei: $selectionId", Toast.LENGTH_SHORT).show()
}