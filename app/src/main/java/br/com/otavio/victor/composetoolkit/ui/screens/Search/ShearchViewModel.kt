package br.com.otavio.victor.composetoolkit.ui.screens.Search

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

// 0) COMO CRIAR O VIEW MODEL DO CAMPO DE BUSCA
// 1) COMO CRIAR UM ICON PADRÃO REUTILIZÁVEL
// 2) COMO CRIAR OS ICONES DE BUSCA PARTINDO DO ICONE PADRÃO
// 3) COMO CRIAR UM CAMPO DE BUSCA E CONFIGURAR O CAMPO DE TEXTO
// 4) COMO CRIAR O COMPONENTE DE BUSCA USANDO O CAMPO DE BUSCA

// 0) COMO CRIAR O VIEW MODEL DO CAMPO DE BUSCA
class ShearchViewModel : ViewModel() {
    private val _isShowingSearchField: MutableState<Boolean> = mutableStateOf(false)
    val isShowingSearchField: State<Boolean> = _isShowingSearchField

    private val _currentSearchText: MutableState<String> = mutableStateOf(value = "")
    val currentSearchText: State<String> = _currentSearchText

    fun showSearchField(show: Boolean){
        _isShowingSearchField.value = show
    }

    fun setCurrentSearchText(newText: String) {
        _currentSearchText.value = newText
    }
}