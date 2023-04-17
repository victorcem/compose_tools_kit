package br.com.otavio.victor.composetoolkit.ui.screens.FullScreenMessageWithState

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import br.com.otavio.victor.composetoolkit.R
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme

@Composable
fun FullScreenMsgDialogWithState() {
    ToolKitTheme {
        val context = LocalContext.current
        FullScreenMessageWithState(
            icon = R.drawable.ic_warning,
            iconTint = R.color.light_error,
            title = "Falha na conexão",
            message = "O registro não foi salvo!",
            bottomButtonText = "Tentar novamente",
            bottomButtonAction = {
                Toast.makeText(context, "Salvar registro novamente!", Toast.LENGTH_SHORT).show()
            }
        )
    }
}