package com.example.miracles.ui.templates

import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.miracles.Routes
import com.example.miracles.ui.MainViewModel
import com.example.miracles.ui.UiState
import com.example.miracles.ui.theme.BarBgColor

@Composable
fun BottomBar(
    viewModel: MainViewModel,
    uiState: UiState,
    navController: NavController
) {
    BottomAppBar(
        backgroundColor = BarBgColor,
    ) {
        Row( horizontalArrangement = Arrangement.Center ) {
            Box(modifier = Modifier.weight(1f)) {
                Text(
                    uiState.favoritesItemsCount.toString(),
                    fontSize = 24.sp, color = Color.White,
                    modifier = Modifier.padding(start = 7.dp)
                )
                IconButton(onClick = {  }, modifier = Modifier.align(Alignment.Center)) {
                    Icon(Icons.Filled.Favorite, null, tint = Color.White)
                }
            }
            Box(modifier = Modifier.weight(1f)) {
                IconButton(onClick = {  }, modifier = Modifier.align(Alignment.Center)) {
                    Icon(Icons.Filled.Notifications, null, tint = Color.White)
                }
            }
            Box(modifier = Modifier.weight(1f)) {
                Text(
                    uiState.cartItemsCount.toString(),
                    fontSize = 24.sp, color = Color.White,
                    modifier = Modifier.padding(start = 3.dp)
                )
                IconButton(
                    onClick = {
                          navController.navigate(Routes.Cart.name)
                     },
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Icon(Icons.Filled.ShoppingCart, null, tint = Color.White, modifier = Modifier.size(31.dp))
                }
            }
            Box(modifier = Modifier.weight(1f)) {
                IconButton(onClick = {  }, modifier = Modifier.align(Alignment.Center)) {
                    Icon(Icons.Filled.Phone, null, tint = Color.White)
                }
            }
            Box(modifier = Modifier.weight(1f)) {
                IconButton(onClick = {  }, modifier = Modifier.align(Alignment.Center)) {
                    Icon(Icons.Filled.Person, null, tint = Color.White)
                }
            }
        }
    }
}