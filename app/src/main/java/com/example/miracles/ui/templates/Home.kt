package com.example.miracles.ui.templates

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.miracles.R
import com.example.miracles.data.Order
import com.example.miracles.data.orders
import com.example.miracles.ui.MainViewModel
import com.example.miracles.ui.theme.ItemBgColor

@Composable
fun OrderInfo(order: Order) {
    Text(text = order.createdAt.toString(), color = Color.White)
    IconButton(onClick = { /*TODO*/ }) {
        Icon(Icons.Filled.Refresh, null, tint = Color.White)
    }
    IconButton(onClick = { /*TODO*/ }) {
        Icon(Icons.Filled.ArrowDropDown, null, tint = Color.White)
    }
    Text(text = order.cart.total.toString(), color = Color.White)
}

@Composable
fun OrderItems() {

}

@Composable
fun HomeScreen(
    viewModel: MainViewModel
) {
    Column {
        if(orders.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(14.dp)
            ) {
                Box(modifier = Modifier
                    .background(ItemBgColor)
                    .padding(24.dp, 30.dp)
                    .clip(RoundedCornerShape(11.dp))
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(R.string.no_orders_text),
                            color = Color.White,
                            fontSize = 24.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(bottom = 22.dp)
                        )
                    }
                }
            }
        } else {
            for(order in orders) {
                OrderInfo(order)
                OrderItems()
            }
        }
    }
}
