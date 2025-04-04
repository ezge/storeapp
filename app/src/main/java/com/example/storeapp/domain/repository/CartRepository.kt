package com.example.storeapp.domain.repository

import com.example.storeapp.domain.model.Product

interface CartRepository {
    fun addToCart(product: Product)
    fun removeFromCart(product: Product)
    fun getCartItems(): List<Product>
    fun clearCart()
}