package com.example.storeapp.domain.repository

import com.example.storeapp.domain.model.Order
import com.example.storeapp.domain.model.OrderStatus

interface OrderRepository {
    suspend fun placeOrder(order: Order): Boolean
}