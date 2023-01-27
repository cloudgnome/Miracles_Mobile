package com.example.miracles

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.miracles.ui.MainViewModel
import com.example.miracles.ui.templates.*
import com.example.miracles.ui.templates.catalog.Category
import com.example.miracles.ui.templates.catalog.Favorites
import com.example.miracles.ui.templates.checkout.Checkout
import com.example.miracles.ui.templates.user.Profile
import com.example.miracles.ui.templates.user.authorization.SignIn
import com.example.miracles.ui.templates.user.authorization.SignUp
import com.example.miracles.ui.theme.BarBgColor
import com.example.miracles.ui.theme.CartBgColor

enum class Routes(@StringRes val title: Int) {
    Home(title = R.string.home_title),
    Category(title = R.string.category_title),
    Cart(title = R.string.cart_title),
    Favorites(title = R.string.favorites_title),
    Profile(title = R.string.profile_title),
    SignIn(title = R.string.signin_title),
    SignUp(title = R.string.signup_title),
    Checkout(title = R.string.checkout_title)
}

@Composable
fun MiraclesApp(
    viewModel: MainViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Routes.valueOf(
        backStackEntry?.destination?.route ?: Routes.Home.name
    )
    LoadBackground(uiState.backgroundImage)

    Scaffold(
        topBar = {
            TopBar(
                viewModel,
                currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = {
                    navController.navigateUp()
                }
            )
        },
        bottomBar = {
            BottomBar(
                viewModel,
                uiState,
                navController
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Routes.Category.name) }, backgroundColor = BarBgColor) {
                Icon(uiState.addButtonType, null, tint = uiState.addButtonColor)
            }
        },
        backgroundColor = uiState.backgroundColor
    ) {
        NavHost(
            modifier = Modifier,
            navController = navController,
            startDestination = Routes.Home.name
        ) {
            composable(route = Routes.Home.name) {
                viewModel.updateScreenBgColor(Color.Transparent)
                viewModel.updateAddButton(Icons.Filled.PlayArrow, Color.White)
                viewModel.updateBackgroundImage(R.drawable.bg_image_house1)
                HomeScreen(
                    viewModel = viewModel
                )
            }
            composable(route = Routes.Category.name) {
                Category(viewModel = viewModel)
            }
            composable(route = Routes.Cart.name) {
                viewModel.updateScreenBgColor(CartBgColor)
                viewModel.updateAddButton(Icons.Filled.Check, Color.Green)
                viewModel.updateBackgroundImage(R.drawable.shopping)
                Cart(viewModel = viewModel, uiState = uiState, navController = navController)
            }
            composable(route = Routes.Favorites.name) {
                Favorites(viewModel = viewModel)
            }
            composable(route = Routes.Profile.name) {
                Profile(viewModel = viewModel, uiState = uiState, navController = navController)
            }
            composable(route = Routes.SignIn.name) {
                SignIn(viewModel = viewModel, uiState = uiState, navController = navController)
            }
            composable(route = Routes.SignUp.name) {
                SignUp(viewModel = viewModel, uiState = uiState, navController = navController)
            }
            composable(route = Routes.Checkout.name) {
                Checkout(viewModel = viewModel, uiState = uiState, navController = navController)
            }
        }
    }
}