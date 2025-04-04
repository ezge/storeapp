package com.example.storeapp.domain.usecase

import com.example.storeapp.domain.model.Product
import com.example.storeapp.domain.repository.ProductRepository

// Fetches product list
class GetProductsUseCase(private val productRepository: ProductRepository) {
    suspend operator fun invoke(): List<Product> {
        return productRepository.getProducts()
    }
}