package com.example.storeapp.presentation.ui


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.storeapp.presentation.components.OrderStatusMessage
import com.example.storeapp.presentation.viewmodel.CheckoutViewModel

@Composable
fun CheckoutScreen(checkoutViewModel: CheckoutViewModel, onBackToHomeClick: () -> Unit) {
    val orderStatus = checkoutViewModel.orderStatus.collectAsState()

    Column(Modifier.padding(16.dp)) {
        Text("Checkout")
        orderStatus.value?.let { OrderStatusMessage(it) }

        Button(onClick = onBackToHomeClick, modifier = Modifier.padding(top = 16.dp)) {
            Text("Back to Home")
        }
    }
}