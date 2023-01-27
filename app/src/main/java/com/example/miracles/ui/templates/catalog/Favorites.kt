package com.example.miracles.ui.templates.catalog

import androidx.compose.runtime.Composable
import com.example.miracles.ui.MainViewModel

@Composable
fun Favorites(
    viewModel: MainViewModel
) {
    Products(viewModel = viewModel, items = viewModel.loadFavorites())
}