package com.example.storeapp.data.api

import com.example.storeapp.domain.model.Product

class ProductApi {
    suspend fun fetchProducts(): List<Product> {
        return listOf(
            Product(1, "Football", 29.99, "Football", "https://example.com/football.jpg"),
            Product(2, "Basketball", 24.99, "Basketball", "https://example.com/basketball.jpg")
        )
    }
}