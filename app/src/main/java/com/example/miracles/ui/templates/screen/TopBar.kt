package com.example.miracles.ui.templates

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.miracles.R
import com.example.miracles.Routes
import com.example.miracles.ui.MainViewModel
import com.example.miracles.ui.SearchWidgetState
import com.example.miracles.ui.theme.BarBgColor

@Composable
fun TopBar(
    viewModel: MainViewModel,
    currentScreen: Routes,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit
) {
    val searchWidgetState by viewModel.searchWidgetState.collectAsState()
    val searchTextState by viewModel.searchTextState

    when(searchWidgetState) {
        SearchWidgetState.CLOSED -> {
            TopAppBar(
                elevation = 2.dp,
                title = {
                    Text(stringResource(currentScreen.title), color = Color.White)
                },
                backgroundColor = BarBgColor,
                navigationIcon = {
                    if(canNavigateBack) {
                        IconButton(onClick = { navigateUp() }) {
                            Icon(Icons.Filled.ArrowBack, stringResource(R.string.back_button), tint = Color.White)
                        }
                    } else {
                        IconButton(onClick = {/* Do Something*/ }) {
                            Icon(Icons.Filled.Menu, null, tint = Color.White)
                        }
                    }
                }, actions = {
                    IconButton(onClick = { viewModel.updateSearchWidgetState(SearchWidgetState.OPENED) }) {
                        Icon(Icons.Filled.Search, null, tint = Color.White)
                    }
                }
            )
        }
        SearchWidgetState.OPENED -> {
            SearchBar(
                text = searchTextState,
                onCloseClicked = {
                    viewModel.updateSearchText("")
                    viewModel.updateSearchWidgetState(
                        SearchWidgetState.CLOSED
                    )
                },
                onSearchClicked = { },
                onTextChange = { viewModel.updateSearchText(it) }
            )
        }
    }
}

@Composable
fun SearchBar(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit,
){
    Surface (
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = BarBgColor
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = { onTextChange(it) },
            placeholder = {
                Text(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    text = "Пошук",
                    color = Color.White
                )
            },
            textStyle = TextStyle(
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    onClick = {

                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Пошук",
                        tint = Color.White
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    onClick = {
                        if(text.isNotEmpty()){
                            onTextChange("")
                        } else {
                            onCloseClicked()
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Закрити",
                        tint = Color.White
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                textColor = Color.White,
                cursorColor = Color.White.copy(alpha = ContentAlpha.medium)
            )
        )
    }
}