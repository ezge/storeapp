package com.example.storeapp.presentation.navigation

sealed class Screen(val route: String) {
    object ProductList : Screen("product_list")
    object Cart : Screen("cart")
    object Checkout : Screen("checkout")
}