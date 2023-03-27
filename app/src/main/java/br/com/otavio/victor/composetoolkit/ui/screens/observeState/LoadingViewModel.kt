package br.com.otavio.victor.composetoolkit.ui.screens.observeState

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class LoadingViewModel : ViewModel() {
    val loadingStateFlow = MutableStateFlow(false)

    fun setLodingState(loading: Boolean) {
        viewModelScope.launch {
            loadingStateFlow.emit(loading)
        }
    }
}