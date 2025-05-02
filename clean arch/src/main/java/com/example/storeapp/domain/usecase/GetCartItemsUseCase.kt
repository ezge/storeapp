package com.example.storeapp.domain.usecase

import com.example.storeapp.domain.model.Product
import com.example.storeapp.domain.repository.CartRepository

// Retrieves cart items
class GetCartItemsUseCase(private val repository: CartRepository) {
    operator fun invoke(): List<Product> {
        return repository.getCartItems()
    }
}