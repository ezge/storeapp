package com.example.storeapp.domain.model

sealed class OrderStatus{
    object Success : OrderStatus()
    object Failure : OrderStatus()
    object Loading : OrderStatus()
}