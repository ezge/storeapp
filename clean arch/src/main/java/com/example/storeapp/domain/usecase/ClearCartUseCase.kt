package com.example.storeapp.domain.usecase

import com.example.storeapp.domain.repository.CartRepository

// Clears the cart
class ClearCartUseCase(private val repository: CartRepository) {
    operator fun invoke() {
        repository.clearCart()
    }
}