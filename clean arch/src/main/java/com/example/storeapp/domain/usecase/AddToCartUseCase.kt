package com.example.storeapp.domain.usecase

import com.example.storeapp.domain.model.Product
import com.example.storeapp.domain.repository.CartRepository

// Adds a product to cart
class AddToCartUseCase (private val repository: CartRepository){
    operator fun invoke(product: Product) {
        repository.addToCart(product)
    }
}