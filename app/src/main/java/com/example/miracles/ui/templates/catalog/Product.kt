package com.example.miracles.ui.templates.catalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.example.miracles.R
import com.example.miracles.data.Item
import com.example.miracles.data.Product
import com.example.miracles.ui.MainViewModel
import com.example.miracles.ui.theme.ItemBgColor

@Composable
fun Image(image: Int) {
    val image = painterResource(id = image)
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 7.dp)
    )
}

@Composable
fun Name(name: String?) {
    Text(
        text = name.toString(),
        color = Color(255,255,255),
        fontSize = 12.sp,
        textAlign = TextAlign.Start,
        modifier = Modifier.padding(start = 8.dp,top = 21.dp, bottom = 18.dp, end = 14.dp)
    )
}

@Composable
fun Price(price: Double) {
    Text(text = "${price}€\u200E", color = Color.White, fontSize = 15.sp,
        textAlign = TextAlign.End,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun Availability(shopName: String) {
    Text(text = shopName, color = Color.White, fontSize = 11.sp)
}

@Composable
fun Product(
    viewModel: MainViewModel,
    item: Item,
    product: Product = item.product
) {
    Card(shape = RoundedCornerShape(4.dp),
        backgroundColor = ItemBgColor,
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, top = 10.dp, bottom = 10.dp)
        ) {
            Row (Modifier.padding(bottom = 14.dp)) {
                Box(Modifier.weight(1f)) {
                    Text("id: ${product.id}", color = Color.White)
                }
                Box(Modifier.weight(1f)) {
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Row (
                            modifier = Modifier.padding(top = 3.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            IconButton(
                                modifier = Modifier
                                    .size(17.dp),
                                onClick = {
                                    viewModel.addFavorite(product.id)
                                }
                            ) {
                                Icon(
                                    viewModel.productFavoritesIcon(product.id),
                                    null,
                                    tint = Color.Transparent,
                                )
                            }
                        }
                    }
                }
            }
            Image(product.image)
            Row {
                Box(
                    Modifier
                        .weight(1f)
                        .padding(top = 5.dp)) {
                    Availability(product.shop().name)
                }
                Box(
                    Modifier
                        .weight(1f)
                        .fillMaxWidth()) {
                    Price(product.price)
                }
            }
            Row() {
                Box(modifier = Modifier.weight(1f)) {
                    Name(product.name)
                }
                Box(modifier = Modifier.width(24.dp)) {
                    IconButton(
                        onClick = {
                            viewModel.buyItem(id = product.id, qty = "1")
                        }
                    ) {
                        Icon(
                            Icons.Filled.ShoppingCart,
                            null,
                            Modifier.size(24.dp),
                            tint = Color.White
                        )
                    }
                }
            }

        }
    }
}