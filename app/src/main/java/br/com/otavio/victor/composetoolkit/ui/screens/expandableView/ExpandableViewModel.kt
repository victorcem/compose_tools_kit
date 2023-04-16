package br.com.otavio.victor.composetoolkit.ui.screens.expandableView

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.reflect.KProperty

// +----------------------------------------------+
// | HOISTING - ELEVANDO O ESTADO PARA O MODELO   |
// +----------------------------------------------+
class ExpandableViewModel : ViewModel() {
    private val _state = MutableStateFlow(false)
    val state: StateFlow<Boolean>
        get() = _state

    fun toggleState(newState: Boolean) {
        viewModelScope.launch {
            _state.emit(newState)
        }
    }
}

// +--------------------------------------------------------+
// | ViewModel que resiste a mudanças de configurações      |
// +--------------------------------------------------------+
class SaveableViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    var saveableMutableComposeState by SaveableComposeState(savedStateHandle, "ComposeKey", false)
        private set

    fun triggerComposeState(newState: Boolean) {
        saveableMutableComposeState = newState
    }

}

// +--------------------------------------------------------+
// | Modelagem do estado generico para view models          |
// +--------------------------------------------------------+
class SaveableComposeState<T>(
    private val savedStateHandle: SavedStateHandle,
    private val key: String,
    defaultValue: T
) {
    private var _state by mutableStateOf(savedStateHandle.get<T>(key) ?: defaultValue)

    operator fun getValue(
        thisRef: Any?,
        property: KProperty<*>
    ) : T {
        return _state
    }

    operator fun setValue(
        thisRef: Any?,
        property: KProperty<*>,
        value: T
    ) {
        _state = value
        savedStateHandle[key] = value
    }
}
