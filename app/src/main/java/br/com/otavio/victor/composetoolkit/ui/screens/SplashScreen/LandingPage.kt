package br.com.otavio.victor.composetoolkit.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.otavio.victor.composetoolkit.R
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme
import kotlinx.coroutines.delay

// 1) O QUE SÃO SIDE-EFFECTS E QUANDO ELES ENTRAM NO JOGO?
// Um efeito colateral no Compose é uma alteração no estado do aplicativo que acontece fora
// do escopo de uma função que pode ser composta.

// 2) COMO CRIAR UMA LANDING PAGE OU SPLASH SCREEN (COMPONENTE QUE VC VAI PRECISAR 100%)

// 3) POR QUE USAR "rememberUpdatedState" QUANDO USAR SIDE-EFFECTS
// Se onTimeout for alterado enquanto o efeito colateral estiver em andamento,
// não há garantia de que o último onTimeout seja chamado quando o efeito terminar.
// Para garantir isso capturando e atualizando para o novo valor, use a API RememberUpdatedState

// 4) PARA QUE SERVE AS KEYS NOS "SIDE-EFFECT"?
// Algumas APIs de efeito colateral, como LaunchedEffect, usam um número variável de chaves
// como parâmetro que é usado para reiniciar o efeito sempre que uma dessas chaves é alterada.
// Não queremos reiniciar o efeito se o onTimeout for alterado! Por isso passamos uma constante true

@Composable
fun LandingScreen(
    modifier: Modifier = Modifier,
    splashWaitTime: Long,
    onTimeout: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Isso sempre se referirá à última função onTimeout com qual a
        // LandingScreen foi recomposta
        val currentOnTimeout by rememberUpdatedState(newValue = onTimeout)

        // Crie um efeito que corresponda ao ciclo de vida da LandingScreen.
        // Se LandingScreen se recompor ou onTimeout mudar,
        // o atraso não deve começar novamente.
        LaunchedEffect(key1 = true) {// Você pode usar Unit tbm
            delay(splashWaitTime)
            currentOnTimeout()
        }

        Image(
            painter = painterResource(id = R.drawable.ic_droid),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(10.dp))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LandingPageLightPreview() {
    ToolKitTheme {
        LandingScreen(
            modifier = Modifier,
            splashWaitTime = 1_500L,
            onTimeout = {}
        )
    }
}