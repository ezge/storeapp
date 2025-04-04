package com.example.storeapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storeapp.domain.model.Order
import com.example.storeapp.domain.model.OrderStatus
import com.example.storeapp.domain.model.Product
import com.example.storeapp.domain.usecase.PlaceOrderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CheckoutViewModel @Inject constructor(private val placeOrderUseCase: PlaceOrderUseCase) : ViewModel() {
    private val _orderStatus = MutableStateFlow<OrderStatus?>(null)
    val orderStatus: StateFlow<OrderStatus?> get() = _orderStatus

    fun checkout(cart: List<Product>) {
        viewModelScope.launch {
            _orderStatus.value = OrderStatus.Loading
            val totalAmount = cart.sumOf { it.price }
            val order = Order(cart, totalAmount)
            _orderStatus.value = if (placeOrderUseCase(order)) OrderStatus.Success else OrderStatus.Failure
        }
    }
}