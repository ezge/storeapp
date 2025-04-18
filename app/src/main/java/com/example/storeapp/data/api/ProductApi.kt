package com.example.storeapp.data.api

import com.example.storeapp.domain.model.Product
import javax.inject.Inject


/**
 * Simulates a network API for fetching products.
 * In a real application, this would make network calls to a remote server.
 */
class ProductApi @Inject constructor(){
    suspend fun fetchProducts(): List<Product> {
        return listOf(
            Product(1, "Football", 29.99, "Football", "https://example.com/football.jpg"),
            Product(2, "Basketball", 24.99, "Basketball", "https://example.com/basketball.jpg")
        )
    }
}