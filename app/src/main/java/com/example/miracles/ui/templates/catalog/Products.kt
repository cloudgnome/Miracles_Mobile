package com.example.miracles.ui.templates.catalog

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.miracles.data.Item
import com.example.miracles.ui.MainViewModel

@Composable
fun Products(
    viewModel: MainViewModel,
    items: MutableList<Item>
) {
    Column (
        modifier = Modifier.padding(bottom = 74.dp),
    ) {
        Box(modifier = Modifier.padding(start = 5.dp, end = 5.dp)) {

            val scrollStateVertical = rememberScrollState()

            val columns = items.partition { it.id % 2 == 0 }.toList()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(state = scrollStateVertical)
            ) {
                Row() {
                    for(column in columns) {
                        Box(modifier = Modifier.weight(1f)) {
                            Column(modifier = Modifier.fillMaxWidth()) {
                                for (item in column) {
                                    Box {
                                        Product(
                                            viewModel,
                                            item
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
