package com.example.storeapp.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.storeapp.presentation.viewmodel.CartViewModel
import com.example.storeapp.presentation.viewmodel.CheckoutViewModel
import com.example.storeapp.StoreApp
import com.example.storeapp.presentation.navigation.StoreNavGraph
import com.example.storeapp.presentation.theme.StoreAppTheme
import com.example.storeapp.presentation.viewmodel.ProductListViewModel
import dagger.hilt.android.AndroidEntryPoint

// Entry point of the app
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StoreAppTheme {
                val navController = rememberNavController()

                val productListViewModel: ProductListViewModel = viewModel()
                val cartViewModel: CartViewModel = viewModel()
                val checkoutViewModel: CheckoutViewModel = viewModel()

                StoreNavGraph(
                    navController = navController,
                    productListViewModel = productListViewModel,
                    cartViewModel = cartViewModel,
                    checkoutViewModel = checkoutViewModel
                )
            }
            StoreApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StoreAppTheme {
        StoreApp()
    }
}