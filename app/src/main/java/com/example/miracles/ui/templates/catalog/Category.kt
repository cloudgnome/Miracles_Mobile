package com.example.miracles.ui.templates.catalog

import androidx.compose.runtime.Composable
import com.example.miracles.data.products
import com.example.miracles.ui.MainViewModel

@Composable
fun Category(
    viewModel: MainViewModel
) {
    Products(viewModel = viewModel, items = products)
}