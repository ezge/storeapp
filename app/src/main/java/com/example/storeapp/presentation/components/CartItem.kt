package com.example.storeapp.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.storeapp.domain.model.Product
import com.example.storeapp.presentation.viewmodel.CartViewModel

@Composable
fun CartItem(product: Product, cartViewModel: CartViewModel) {
    Row(Modifier.padding(16.dp)) {
        Text(text = product.name)
        Button(onClick = { cartViewModel.removeFromCart(product) }) {
            Text("Remove")
        }
    }
}