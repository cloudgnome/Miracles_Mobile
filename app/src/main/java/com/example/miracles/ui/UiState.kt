package com.example.miracles.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.miracles.R
import com.example.miracles.ui.theme.MainBgColor

data class UiState(
    val products: MutableMap<String,MutableMap<String,String>> = mutableMapOf(),
    val searchWord: String = "",
    var cartItemsCount: Int = 0,
    var favoritesItemsCount: Int = 0,
    var backgroundColor: Color = MainBgColor,
    var addButtonType: ImageVector = Icons.Filled.Add,
    var addButtonColor: Color = Color.White,
    var backgroundImage: Int = R.drawable.bg_image_house1
)

enum class SearchWidgetState{
    OPENED,
    CLOSED
}