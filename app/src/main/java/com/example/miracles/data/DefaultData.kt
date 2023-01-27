package com.example.miracles.data

import com.example.miracles.R
import java.util.*

val OPENED: Boolean = true
val CLOSED: Boolean = false

class Shop(
    val id: Int,
    val name: String
)

val shops = listOf(
    Shop(id = 1, name = "Jumbo"),
    Shop(id = 2, name = "Plus"),
    Shop(id = 3, name = "Netto"),
    Shop(id = 4, name = "Norma")
)

class Product(
    val id: Int,
    val name: String,
    val shop_id: Int,
    val price: Double,
    val image: Int,
    val qty: String = "0"
) {
    fun shop(): Shop {
        return shops.first { it.id == shop_id }
    }
}

class User(
    val id: Int,
    val full_name: String,
    val avatar: String,
    val active: Boolean
)

class Item(
    val id: Int,
    val product: Product,
    var qty: String = ""
)

class Cart(
    val id: Int,
    val items: MutableList<Item> = mutableListOf(),
    val total: Double = 0.0,
) {
    fun size(): Int {
        return items.size
    }
    fun isNotEmpty(): Boolean {
        return items.isNotEmpty()
    }
    fun getItem(id: Int): Item? {
        return items.firstOrNull { it.product.id == id }
    }
}

var carts = mutableListOf<Cart>()

class Order(
    val id: Int,
    val cart: Cart,
    val createdAt: Date,
    val updatedAt: Date,
    val user: User,
)

var orders = mutableListOf<Order>()

var favorites = mutableListOf<Product>()

val products = mutableListOf(
    Item(
        id = 1,
        Product(id = 1, name = "Шокобанан коробка большая", shop_id = 4, price = 3.toDouble(), image = R.drawable.bananen)
    ),
    Item(
        id = 2,
        Product(id = 2, name = "Сир 500-600гр", shop_id = 1, price = 6.toDouble(), image = R.drawable.cheese)
    ),
    Item(
        id = 3,
        Product(id = 3, name = "Хліб велика буханка", shop_id = 2, price = 1.5, image = R.drawable.bread)
    ),
    Item(
        id = 4,
        Product(id = 4, name = "Пончики 6шт", shop_id = 4, price = 3.toDouble(), image = R.drawable.donuts),
    ),
    Item(
        id = 5,
        Product(id = 5, name = "Мандаринки", shop_id = 3, price = 2.toDouble(), image = R.drawable.mandarin),
    ),
    Item(
        id = 6,
        Product(id = 6, name = "Оливи чорні", shop_id = 3, price = 4.toDouble(), image = R.drawable.black_olives),
    ),
    Item(
        id = 7,
        Product(id = 7, name = "Ананас консерв. банка", shop_id = 3, price = 2.toDouble(), image = R.drawable.ananas),
    ),
    Item(
        id = 8,
        Product(id = 8, name = "Батон маленький", shop_id = 3, price = .19, image = R.drawable.brod),
    ),
    Item(
        id = 9,
        Product(id = 9, name = "Батон великий", shop_id = 3, price = .39, image = R.drawable.big_brod),
    ),
    Item(
        id = 10,
        Product(id = 10, name = "Полуничний варення", shop_id = 2, price = 1.55, image = R.drawable.strawberry_jam),
    ),
    Item(
        id = 11,
        Product(id = 11, name = "Абрикосовий варення", shop_id = 2, price = 1.36, image = R.drawable.appricot_jam),
    ),
    Item(
        id = 12,
        Product(id = 12, name = "Помідор маленький", shop_id = 2, price = 1.59, image = R.drawable.cherry_tomato),
    ),
    Item(
        id = 13,
        Product(id = 13, name = "Малина", shop_id = 2, price = 3.99, image = R.drawable.red_raspberries),
    ),
    Item(
        id = 14,
        Product(id = 14, name = "Банан(скидка)", shop_id = 2, price = 1.39, image = R.drawable.banana),
    ),
//    Product(id = 15, name = "Круасан", shop_id = 2, price = 0.89, image = "bananen"),
//    Product(id = 16, name = "Цибуля біла 12штук", shop_id = 2, price = 1.69, image = "bananen"),
//    Product(id = 17, name = "Полуничний пиріг", shop_id = 2, price = 7.99, image = "bananen"),
//    Product(id = 18, name = "Паркування Arnhem 40хв", shop_id = 2, price = 2.toDouble(), image = "bananen"),
//    Product(id = 19, name = "Яйця", shop_id = 4, price = 2.29, image = "bananen"),
//    Product(id = 20, name = "Йогурт", shop_id = 4, price = 0.59, image = "bananen", qty = "3"),
//    Product(id = 21, name = "Зерновий йогурт", shop_id = 4, price = 0.49, image = "bananen"),
//    Product(id = 22, name = "Цибуля", shop_id = 4, price = 0.18, image = "bananen"),
//    Product(id = 23, name = "Майонез", shop_id = 4, price = 1.69, image = "bananen"),
//    Product(id = 24, name = "Маленькі булочки", shop_id = 4, price = 0.17, image = "bananen"),
//    Product(id = 25, name = "Пончики", shop_id = 4, price = 2.29, image = "bananen"),
//    Product(id = 26, name = "Ковбаса нарізана", shop_id = 4, price = 1.29, image = "bananen"),
//    Product(id = 27, name = "Куркума", shop_id = 4, price = 0.69, image = "bananen"),
//    Product(id = 28, name = "Кукурудзяні хлопавки", shop_id = 4, price = 1.99, image = "bananen"),
)