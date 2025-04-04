package com.example.storeapp.data.repository

import com.example.storeapp.data.api.ProductApi
import com.example.storeapp.domain.model.Product
import com.example.storeapp.domain.repository.ProductRepository

class ProductRepositoryImpl(private val api: ProductApi) : ProductRepository {
    override suspend fun getProducts(): List<Product> {
        return api.fetchProducts()
    }
}