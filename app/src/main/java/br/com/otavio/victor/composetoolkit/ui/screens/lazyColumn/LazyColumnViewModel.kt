package br.com.otavio.victor.composetoolkit.ui.screens.lazyColumn

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class LazyColumnViewModel : ViewModel() {

    val items = MutableStateFlow<MutableList<Item>>(mutableStateListOf())
    val registerId = MutableStateFlow("")

    fun setItems(Items: List<Item>) {
        viewModelScope.launch {
            this@LazyColumnViewModel.items.emit(items as MutableList<Item>)
        }
    }

    fun removeItem(item: Item) {
        items.value = items.value.filter { it != item }.toMutableList()
    }

    //Setings Animation
    fun navigateTo(destinationId: Int) {
        Log.d("TESTANDO", "Nague para destination: $destinationId")
    }

    fun getLastItemID(): Int = items.value.last().id

    fun detRegisterId(id: String) {
        viewModelScope.launch {
            registerId.emit(id)
        }
    }
}