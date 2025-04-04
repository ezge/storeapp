package com.example.storeapp.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.storeapp.presentation.components.CartItem
import com.example.storeapp.presentation.viewmodel.CartViewModel


@Composable
fun CartScreen(cartViewModel: CartViewModel, onCheckoutClick: () -> Unit) {
    val cart = cartViewModel.cart.collectAsState()

    Column {
        Text("Cart Items", Modifier.padding(16.dp))
        LazyColumn {
            items(cart.value) { product ->
                CartItem(product, cartViewModel)
            }
        }
        Button(onClick = onCheckoutClick, modifier = Modifier.padding(16.dp)) {
            Text("Proceed to Checkout")
        }
    }
}