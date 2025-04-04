package com.example.storeapp.domain.usecase

import com.example.storeapp.domain.model.Product
import com.example.storeapp.domain.repository.CartRepository

// Removes a product from cart
class RemoveFromCartUseCase(private val repository: CartRepository) {
    operator fun invoke(product: Product) {
        repository.removeFromCart(product)
    }
}