package com.example.storeapp.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import com.example.storeapp.domain.model.OrderStatus

@Composable
fun OrderStatusMessage(status: OrderStatus) {
    Text(
        text = when (status) {
            OrderStatus.Success -> "Order placed successfully!"
            OrderStatus.Failure -> "Order failed."
            OrderStatus.Loading -> "Processing order..."
        },
        modifier = Modifier.padding(16.dp)
    )
}