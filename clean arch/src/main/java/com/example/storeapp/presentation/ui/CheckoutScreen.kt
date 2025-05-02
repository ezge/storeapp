package com.example.storeapp.presentation.ui


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.storeapp.domain.model.Order
import com.example.storeapp.presentation.components.CartItem
import com.example.storeapp.presentation.components.OrderStatusMessage
import com.example.storeapp.presentation.viewmodel.CartViewModel
import com.example.storeapp.presentation.viewmodel.CheckoutViewModel

@Composable
fun CheckoutScreen(checkoutViewModel: CheckoutViewModel,
                    cartViewModel: CartViewModel,
                    onBackToHomeClick: () -> Unit) {

    val orderStatus = checkoutViewModel.orderStatus.collectAsState()

    Column(Modifier.padding(16.dp)) {
        Text("Checkout")
        Text("Total: ${'$'}${cartViewModel.getTotalPrice()}",
              modifier = Modifier.padding(16.dp))
        orderStatus.value?.let { OrderStatusMessage(it) }

        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onBackToHomeClick, modifier = Modifier.padding(top = 16.dp)) {
            Text("Back to Home")
        }
    }
}