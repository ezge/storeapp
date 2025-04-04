package com.example.storeapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.storeapp.presentation.ui.CartScreen
import com.example.storeapp.presentation.ui.CheckoutScreen
import com.example.storeapp.presentation.ui.ProductListScreen
import com.example.storeapp.presentation.viewmodel.CartViewModel
import com.example.storeapp.presentation.viewmodel.CheckoutViewModel
import com.example.storeapp.presentation.viewmodel.ProductListViewModel

@Composable
fun StoreNavGraph(
    navController: NavHostController,
    productListViewModel: ProductListViewModel,
    cartViewModel: CartViewModel,
    checkoutViewModel: CheckoutViewModel
) {
    NavHost(navController = navController, startDestination = Screen.ProductList.route) {
        composable(Screen.ProductList.route) {
            ProductListScreen(
                viewModel = productListViewModel,
                cartViewModel = cartViewModel,
                checkoutViewModel = checkoutViewModel,
                onCartClick = { navController.navigate(Screen.Cart.route) }
            )
        }

        composable(Screen.Cart.route) {
            CartScreen(
                cartViewModel = cartViewModel,
                onCheckoutClick = { navController.navigate(Screen.Checkout.route) }
            )
        }

        composable(Screen.Checkout.route) {
            CheckoutScreen(
                checkoutViewModel = checkoutViewModel,
                onBackToHomeClick = { navController.popBackStack(Screen.ProductList.route, false) }
            )
        }
    }
}