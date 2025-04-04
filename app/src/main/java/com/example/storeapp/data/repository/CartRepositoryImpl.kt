package com.example.storeapp.data.repository

import com.example.storeapp.domain.model.Product
import com.example.storeapp.domain.repository.CartRepository

class CartRepositoryImpl : CartRepository {
    private val cartItems = mutableListOf<Product>()
    override fun addToCart(product: Product) { cartItems.add(product) }
    override fun removeFromCart(product: Product) { cartItems.remove(product) }
    override fun clearCart() { cartItems.clear() }
    override fun getCartItems(): List<Product> = cartItems
}