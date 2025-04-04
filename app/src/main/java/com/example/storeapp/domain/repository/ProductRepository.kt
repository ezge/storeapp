package com.example.storeapp.domain.repository

import com.example.storeapp.domain.model.Product

interface ProductRepository {
    suspend fun getProducts(): List<Product>
}