package com.example.storeapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.storeapp.domain.model.Product
import com.example.storeapp.presentation.viewmodel.CartViewModel

@Composable
fun ProductItem(product: Product, cartViewModel: CartViewModel) {
    Row(Modifier.padding(16.dp)) {
        Image(
            painter = rememberImagePainter(product.imageUrl),
            contentDescription = product.name,
            modifier = Modifier.size(80.dp)
        )
        Column(Modifier.padding(start = 16.dp)) {
            Text(text = product.name)
            Text(text = "${'$'}${product.price}")
            Button(onClick = { cartViewModel.addToCart(product) }) {
                Text("Add to Cart")
            }
        }
    }
}