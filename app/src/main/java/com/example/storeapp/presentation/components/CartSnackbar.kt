package com.example.storeapp.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.storeapp.presentation.viewmodel.CartViewModel


@Composable
fun CartSnackbar(cartViewModel: CartViewModel) {
    val message = cartViewModel.snackbarMessage.collectAsState()
    message.value?.let {
        Snackbar(modifier = Modifier.padding(16.dp)) {
            Text(it) }
    }
}
