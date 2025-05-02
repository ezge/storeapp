package com.example.storeapp.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.storeapp.presentation.components.CartItem
import com.example.storeapp.presentation.components.OrderStatusMessage
import com.example.storeapp.presentation.viewmodel.CartViewModel
import com.example.storeapp.presentation.viewmodel.CheckoutViewModel


@Composable
fun CartScreen(cartViewModel: CartViewModel,
               checkoutViewModel: CheckoutViewModel,
               onCheckoutClick: () -> Unit) {
    val cart = cartViewModel.cart.collectAsState()
    val orderStatus by checkoutViewModel.orderStatus.collectAsState()


    Column {
        Text("Cart Items", Modifier.padding(16.dp))
        LazyColumn {
            items(cart.value) { product ->
                CartItem(product, cartViewModel)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        Row (horizontalArrangement = Arrangement.End,
             verticalAlignment = Alignment.CenterVertically) {
            // Display the total price of items in the cart
            Button(
                onClick = { checkoutViewModel.checkout(cart.value) }, // Trigger the checkout process
                modifier = Modifier.padding(16.dp)) {
                Text("Checkout")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = onCheckoutClick,
                   modifier = Modifier.padding(16.dp)) {
                Text("Proceed to Checkout")
            }
        }
        // Display the total price of items in the cart
        Text("Total: ${'$'}${cartViewModel.getTotalPrice()}",
             modifier = Modifier.padding(16.dp))
        // Display order status message if available
        orderStatus?.let {OrderStatusMessage(status = it)}
    }
}