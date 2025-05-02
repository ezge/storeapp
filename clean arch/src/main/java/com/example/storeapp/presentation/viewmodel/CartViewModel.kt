package com.example.storeapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.storeapp.domain.model.Product
import com.example.storeapp.domain.usecase.AddToCartUseCase
import com.example.storeapp.domain.usecase.ClearCartUseCase
import com.example.storeapp.domain.usecase.GetCartItemsUseCase
import com.example.storeapp.domain.usecase.GetTotalAmountUseCase
import com.example.storeapp.domain.usecase.RemoveFromCartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
open class CartViewModel @Inject constructor(
    private val addToCartUseCase: AddToCartUseCase,
    private val removeFromCartUseCase: RemoveFromCartUseCase,
    private val clearCartUseCase: ClearCartUseCase,
    private val getCartItemsUseCase: GetCartItemsUseCase,
    private val getTotalAmountUseCase: GetTotalAmountUseCase
) : ViewModel() {
    private val _cart = MutableStateFlow<List<Product>>(emptyList())
    val cart: StateFlow<List<Product>> get() = _cart

    private val _snackbarMessage = MutableStateFlow<String?>(null)
    val snackbarMessage: StateFlow<String?> get() = _snackbarMessage

    private val _totalAmount = MutableStateFlow(0.0)
    val totalAmount: StateFlow<Double> get() = _totalAmount

    fun addToCart(product: Product) {
        addToCartUseCase(product);
        updateCart()
        _snackbarMessage.value = "${product.name} added to cart"
    }

    fun removeFromCart(product: Product) {
        removeFromCartUseCase(product);
        updateCart()
        _snackbarMessage.value = "${product.name} removed from cart"
    }

    fun clearCart() {
        clearCartUseCase();
        updateCart()
        _snackbarMessage.value = "Cart cleared"
    }

    fun getTotalPrice(): Double {
        return getTotalAmountUseCase()
    }

    private fun updateCart() {
        _cart.value = getCartItemsUseCase()
        _totalAmount.value = getTotalAmountUseCase()
        _snackbarMessage.value = null
    }
}
