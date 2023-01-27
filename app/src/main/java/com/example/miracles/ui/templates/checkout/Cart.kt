package com.example.miracles.ui.templates

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.miracles.ui.MainViewModel
import com.example.miracles.ui.UiState
import com.example.miracles.ui.templates.catalog.Products
import com.example.miracles.ui.theme.ItemBgColor

@Composable
fun Cart(
    viewModel: MainViewModel,
    uiState: UiState,
    navController: NavController
) {
    if(viewModel.cart.isNotEmpty()) {
        Column {
            Products(viewModel = viewModel, items = viewModel.cart.items)
            Row(
                modifier = Modifier.padding(17.dp).background(ItemBgColor).fillMaxWidth()
            ) {
                Text("Товарів у кошику: ${viewModel.cart.size()}", color = Color.White,modifier = Modifier.padding(17.dp))
                Text(" Загальна сума: ${viewModel.cart.total}", color = Color.White,modifier = Modifier.padding(17.dp))
            }
        }
    }
}