package br.com.otavio.victor.composetoolkit.ui.screens.FullScreenMessageWithSaveable

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import br.com.otavio.victor.composetoolkit.R
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme

@Composable
fun FullScreenMsgDialogWithSaveable() {
    ToolKitTheme {
        val context = LocalContext.current
        FullScreenMessageWithSaveable(
            icon = R.drawable.ic_verified,
            iconTint = R.color.light_inversePrimary,
            title = "Verificação",
            message = "Sua conta esta sendo verificada!",
            bottomButtonText = "Ok, entrendi!",
            bottomButtonAction = {
                Toast.makeText(context,"Fechado Dialog Informativo!", Toast.LENGTH_SHORT).show()
            }
        )

    }
}