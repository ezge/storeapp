package com.example.storeapp.domain.usecase

import com.example.storeapp.domain.repository.CartRepository

class GetTotalAmountUseCase(private val repository: CartRepository) {
    operator fun invoke(): Double {
        return repository.getTotalAmount()
    }
}