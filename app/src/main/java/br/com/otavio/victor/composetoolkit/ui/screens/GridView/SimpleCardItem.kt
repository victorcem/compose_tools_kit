package br.com.otavio.victor.composetoolkit.ui.screens.GridView

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

// 1) COMO CRIAR A CLASSE DE DADOS DO CARD VIEW
// 2) COMO CRIAR O COMPONENTE DE GRADE USANDO O LAZY HORIZONTAL GRID
// 3) COMO CRIAR O PREVIEW E COMO USAR NA PRÁTICA

// 1) COMO CRIAR A CLASSE DE DADOS DO CARD VIEW
data class SimpleCardItem(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int,
    val id: Int
)
