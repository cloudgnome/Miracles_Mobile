package com.example.miracles.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import com.example.miracles.data.Cart
import com.example.miracles.data.Item
import com.example.miracles.data.Product
import com.example.miracles.data.products
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel: ViewModel() {
    var cart_index: Int = 1
    var item_index: Int = 1

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _searchWidgetState:  MutableStateFlow<SearchWidgetState> = MutableStateFlow(value = SearchWidgetState.CLOSED)
    val searchWidgetState: StateFlow<SearchWidgetState> = _searchWidgetState.asStateFlow()

    private val _searchTextState: MutableState<String> = mutableStateOf(value = "")
    val searchTextState: MutableState<String> = _searchTextState

    private var _cart: Cart = Cart(id = cart_index)
    val cart: Cart = _cart

    private var _favorites: MutableList<Int> = mutableListOf()
    val favorites: MutableList<Int> = _favorites

    private fun updateUiState(cartItemsCount: Int) {
        _uiState.update {
            currentState -> currentState.copy(
                cartItemsCount = cartItemsCount
            )
        }
    }
    fun updateSearchWidgetState(state: SearchWidgetState) {
        _searchWidgetState.value = state
    }
    fun updateSearchText(value: String) {
        _searchTextState.value = value
    }
    fun buyItem(id: Int, qty: String) {
        val item = _cart.getItem(id)

        if(item != null) {
            item.qty = item.qty + qty
        } else {
            item_index += 1
            _cart.items.add(
                products.first { it.id == id }
            )
            updateUiState(
                cartItemsCount = _cart.items.size
            )
        }
    }
    fun addFavorite(id: Int) {
        if(!favorites.contains(id)){
            favorites.add(id)
            _uiState.update { currentState -> currentState.copy(favoritesItemsCount = favorites.size) }
        }
    }
    fun updateScreenBgColor(bgColor: Color) {
        _uiState.update {
            currentState -> currentState.copy(
                backgroundColor = bgColor
            )
        }
    }
    fun loadFavorites(): MutableList<Item> {
        val favorites = mutableListOf<Item>()
        for(id in _favorites) {
            favorites.add(products.first { it.id == id })
        }

        return favorites
    }
    fun productFavoritesIcon(productId: Int): ImageVector {
        if(_favorites.contains(productId)) {
            return Icons.Filled.Star
        }
        else {
            return Icons.Outlined.Star
        }
    }
    fun updateAddButton(iconImage: ImageVector, color: Color) {
        _uiState.update {
            currentState -> currentState.copy(
                addButtonType = iconImage,
                addButtonColor = color
            )
        }
    }
    fun updateBackgroundImage(imageResource: Int) {
        _uiState.update {
            currentState -> currentState.copy(
                backgroundImage = imageResource
            )
        }
    }
    fun clearCart() {
        cart_index += 1
        _cart = Cart(id = cart_index)
        _uiState.value = UiState()
    }
}