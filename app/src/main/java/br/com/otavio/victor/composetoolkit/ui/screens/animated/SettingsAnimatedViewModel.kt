package br.com.otavio.victor.composetoolkit.ui.screens.animated

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class SettingsAnimatedViewModel : ViewModel() {

    val items = MutableStateFlow<MutableList<ItemAnimated>>(mutableStateListOf())
    val registerId = MutableStateFlow("")

    fun setItems(items: List<ItemAnimated>) {
        viewModelScope.launch {
            this@SettingsAnimatedViewModel.items.emit(items as MutableList<ItemAnimated>)
        }
    }

    fun removeItem(item: ItemAnimated) {
        items.value = items.value.filter { it != item }.toMutableList()
    }

    fun navigateTo(destinationId: Int) {
        Log.d("TESTANDO", "Navegue para destination: $destinationId")
    }

    fun getLastItemId(): Int = items.value.last().id

    fun setRegisterId(id: String) {
        viewModelScope.launch {
            registerId.emit(id)
        }
    }
}