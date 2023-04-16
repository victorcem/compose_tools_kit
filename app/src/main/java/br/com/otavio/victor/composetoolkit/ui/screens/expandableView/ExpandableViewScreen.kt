package br.com.otavio.victor.composetoolkit.ui.screens.expandableView

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme

@Composable
fun ExpandableViewScreen() {
    // lOCAL STATE (ISSO NÃO É HOISTING, MAS TBM É LEGAL E BOM CONHECER)
    val expanded = remember { mutableStateOf(false) }
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.padding(vertical = 0.dp, horizontal = 8.dp)
    ) {
        DropDownComponent(
            title = "Estado Simples",
            description = "Conteúdo com toda a descrição que eu queira exibir nesta área!",
            minimizeText = "Minimizar",
            maximizeText = "Expandir",
            contentDescription = "Botão de minimizar ou maximizar o conteúdo!",
            expanded.value) { expanded.value = !expanded.value }
    }
}

@Composable
fun ExpandableSavebleViewSreen() {
    // NÃO É HOSTING, MAS ESTA RESISTINDO A MUDANÇAS DE ESTADO
    val expanded = rememberSaveable { mutableStateOf(false) }
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.padding(vertical = 0.dp, horizontal = 8.dp)
    ) {
        DropDownComponent(
            title = "Estado Resistente",
            description = "Conteúdo com toda a descrição que eu queira exibir nesta área!" ,
            minimizeText = "Minimizar",
            maximizeText = "Expandir",
            contentDescription = "Botão de minimizar ou maximizar o conteúdo!",
            expanded.value) { expanded.value = !expanded.value }
    }
}

@Composable
fun ExpandableViewHoisted(viewModel: ExpandableViewModel) {

    // ISSO É HOISTING! ELEVAMOS O ESTADO PARA O VIEW MODEL,
    // VIVE DURANTE O CICLO DE VIDA, POREM NÃO RESISTE (AINDA) A MUDANçA DE CONFIGURAçÃO
    val expanded = viewModel.state.collectAsState().value

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.padding(vertical = 0.dp, horizontal = 8.dp)
    ) {
        DropDownComponent(
            title="Hoisting VM Simples", // NÃO FACA ASSIM, INTERNACIONALIZE! VEJA O VIDEO
            description = "Descrição com toda a descrição que eu queira exibir nesta área!" ,
            minimizeText = "Menos",
            maximizeText = "Mais",
            contentDescription ="Icone de minimizar ou maximizar o conteúdo!",
            expanded) { viewModel.toggleState(!expanded)}
    }
}

// +--------------------------------------------------------------+
// | Usando um view model que resiste a mudança de configuração   |
// +--------------------------------------------------------------+
@Composable
fun ExpandableViewHoistedSavable(viewModel: SaveableViewModel) {

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.padding(vertical = 0.dp, horizontal = 8.dp)
    ) {
        DropDownComponent(
            title="Hoisting VM Configuração", // NÃO FACA ASSIM, INTERNACIONALIZE! VEJA O VIDEO
            description = "Descrição com toda a descrição que eu queira exibir nesta área!" ,
            minimizeText = "Menos",
            maximizeText = "Mais",
            contentDescription ="Icone de minimizar ou maximizar o conteúdo!",
            viewModel.saveableMutableComposeState) { viewModel.triggerComposeState(!viewModel.saveableMutableComposeState)}
    }
}

@Composable
fun ExpandableView(viewModel: SaveableViewModel) {
    ToolKitTheme {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "COM STATES",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
            )
            ExpandableViewScreen()
            ExpandableSavebleViewSreen()
            Spacer(modifier = Modifier.size(24.dp))
            Text(
                text = "COM VIEW MODELS",
                fontWeight = FontWeight.Bold,
                modifier =
                    Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
            )
            ExpandableViewHoisted(ExpandableViewModel())
            ExpandableViewHoistedSavable(viewModel)
        }
    }
}

@Preview
@Composable
fun ExpandableViewLightPreview() {
    ToolKitTheme {
        ExpandableViewScreen()
    }
}

@Preview
@Composable
fun ExpandableViewDarkPreview() {
    ToolKitTheme(useDarkTheme = true) {
        ExpandableViewScreen()
    }
}