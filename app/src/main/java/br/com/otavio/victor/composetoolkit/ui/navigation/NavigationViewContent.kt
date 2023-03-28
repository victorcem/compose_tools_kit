package br.com.otavio.victor.composetoolkit.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.otavio.victor.composetoolkit.ui.components.BottomBar
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitTheme
import br.com.otavio.victor.composetoolkit.ui.theme.ToolKitThemeExtended

// 2) DEFINIR CONTEUDOS DAS TELAS
@Composable
fun ViewContent(name: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.clickable { onClick() },
            text = name,
            fontSize = ToolKitThemeExtended.typography.h1.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeViewContent(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        HomeNavGraph(navController = navController)
    }
}

@Composable
fun LoginContent(
    onLoginClick: () -> Unit,
    onSingUpClick: () -> Unit,
    onForgotClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.clickable { onLoginClick() },
            text = "Login",
            fontSize = ToolKitThemeExtended.typography.h1.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.clickable { onSingUpClick() },
            text = "Sign Up",
            fontSize = ToolKitThemeExtended.typography.h1.fontSize,
            fontWeight = FontWeight.Medium
        )
        Text(
            modifier = Modifier.clickable { onForgotClick() },
            text = "Forgot Password",
            fontSize = ToolKitThemeExtended.typography.h1.fontSize,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview
@Composable
fun ViewContentPreview() {
    ToolKitTheme(useDarkTheme = false) {
        ViewContent("Conteúdo que exibirei!") {}
    }
}

@Preview
@Composable
fun HomeViewContentPreview() {
    ToolKitTheme(useDarkTheme = false) {
        HomeViewContent(rememberNavController())
    }
}

@Preview
@Composable
fun LoginContentPreview() {
    ToolKitTheme (useDarkTheme = false) {
        LoginContent({},{},{})
    }
}
