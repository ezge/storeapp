package com.example.storeapp.presentation.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.collectAsState
import com.example.storeapp.presentation.viewmodel.CartViewModel
import com.example.storeapp.presentation.viewmodel.CheckoutViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.storeapp.presentation.components.ProductItem
import com.example.storeapp.presentation.viewmodel.ProductListViewModel

@Composable
fun ProductListScreen(
    viewModel: ProductListViewModel,
    cartViewModel: CartViewModel,
    checkoutViewModel: CheckoutViewModel,
    onCartClick: () -> Unit
) {
    val products = viewModel.products.collectAsState()

    Column {
        Button(onClick = onCartClick, modifier = Modifier.padding(16.dp)) {
            Text("Go to Cart")
        }
        LazyColumn {
            items(products.value) { product ->
                ProductItem(product, cartViewModel)
            }
        }
    }
}