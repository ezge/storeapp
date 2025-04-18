package com.example.storeapp.data.repository

import com.example.storeapp.data.api.ProductApi
import com.example.storeapp.domain.model.Product
import com.example.storeapp.domain.repository.ProductRepository
import javax.inject.Singleton

@Singleton
class ProductRepositoryImpl(private val api: ProductApi) : ProductRepository {
    override suspend fun getProducts(): List<Product> {
        return api.fetchProducts()
    }
}