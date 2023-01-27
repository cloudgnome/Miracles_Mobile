package com.example.miracles.ui.templates

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.miracles.R

@Composable
fun LoadBackground(backgroundImage: Int) {
    val image = painterResource(id = backgroundImage)
    androidx.compose.foundation.Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.FillHeight,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .fillMaxSize()
    )
}