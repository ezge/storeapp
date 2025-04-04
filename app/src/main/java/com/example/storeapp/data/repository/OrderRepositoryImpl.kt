package com.example.storeapp.data.repository

import com.example.storeapp.domain.model.Order
import com.example.storeapp.domain.repository.OrderRepository

class OrderRepositoryImpl: OrderRepository {
    override suspend fun placeOrder(order: Order): Boolean {
        return true
    }
}