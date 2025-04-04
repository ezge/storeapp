package com.example.storeapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.storeapp.domain.model.Product
import com.example.storeapp.domain.usecase.AddToCartUseCase
import com.example.storeapp.domain.usecase.ClearCartUseCase
import com.example.storeapp.domain.usecase.GetCartItemsUseCase
import com.example.storeapp.domain.usecase.RemoveFromCartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val addToCartUseCase: AddToCartUseCase,
    private val removeFromCartUseCase: RemoveFromCartUseCase,
    private val clearCartUseCase: ClearCartUseCase,
    private val getCartItemsUseCase: GetCartItemsUseCase
) : ViewModel() {
    private val _cart = MutableStateFlow<List<Product>>(emptyList())
    val cart: StateFlow<List<Product>> get() = _cart

    fun addToCart(product: Product) { addToCartUseCase(product); updateCart() }
    fun removeFromCart(product: Product) { removeFromCartUseCase(product); updateCart() }
    fun clearCart() { clearCartUseCase(); updateCart() }
    private fun updateCart() { _cart.value = getCartItemsUseCase() }
}
