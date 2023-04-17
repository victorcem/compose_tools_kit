package br.com.otavio.victor.composetoolkit.ui.screens.FullScreenMessage

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import br.com.otavio.victor.composetoolkit.R
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme

@Composable
fun FullScreenMessageDialog() {
    ToolKitTheme {
        val context = LocalContext.current
        FullScreenMessage(
            icon = R.drawable.ic_warning,
            iconTint = R.color.light_error,
            title = "Atenção",
            message = "Você esta sem internet!",
            topButtonText = "Continuar sem Internet",
            topButtonAction = {
                Toast.makeText(context, "Fechando Dialog", Toast.LENGTH_SHORT).show()
            },
            bottomButtonText = "Configure acesso de Internet",
            bottomButtonAction = {
                Toast.makeText(context, "Abrindo Configurações", Toast.LENGTH_SHORT).show()
            }
        )
    }
}