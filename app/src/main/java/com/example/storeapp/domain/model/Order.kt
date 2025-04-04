package com.example.storeapp.domain.model

data class Order(
    val products: List<Product>,
    val totalAmount: Double
)