package com.example.storeapp.data.di

import com.example.storeapp.data.api.ProductApi
import com.example.storeapp.data.repository.CartRepositoryImpl
import com.example.storeapp.data.repository.OrderRepositoryImpl
import com.example.storeapp.data.repository.ProductRepositoryImpl
import com.example.storeapp.domain.repository.CartRepository
import com.example.storeapp.domain.repository.OrderRepository
import com.example.storeapp.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Provides dependencies for repositories and use cases
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideProductApi(): ProductApi = ProductApi()

    @Provides
    @Singleton
    fun provideProductRepository(api: ProductApi): ProductRepository = ProductRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideCartRepository(): CartRepository = CartRepositoryImpl()

    @Provides
    @Singleton
    fun provideOrderRepository(): OrderRepository = OrderRepositoryImpl()
}