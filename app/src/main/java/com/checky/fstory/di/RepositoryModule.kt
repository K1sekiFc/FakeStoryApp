package com.checky.fstory.di

import com.checky.fstory.ui.data.local.dao.ProductDao
import com.checky.fstory.ui.data.local.datastore.SessionDataStore
import com.checky.fstory.ui.data.remote.api.AuthApi
import com.checky.fstory.ui.data.remote.api.CartApi
import com.checky.fstory.ui.data.remote.api.ProductApi
import com.checky.fstory.ui.data.repository.AuthRepositoryImpl
import com.checky.fstory.ui.data.repository.CartRepositoryImpl
import com.checky.fstory.ui.data.repository.ProductRepositoryImpl
import com.checky.fstory.ui.domain.repository.AuthRepository
import com.checky.fstory.ui.domain.repository.CartRepository
import com.checky.fstory.ui.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(api: AuthApi, session: SessionDataStore): AuthRepository {
        return AuthRepositoryImpl(api, session)
    }

    @Provides
    fun provideProductRepository(api: ProductApi, dao: ProductDao): ProductRepository {
        return ProductRepositoryImpl(api, dao)
    }

    @Provides
    fun provideCartRepository(api: CartApi, session: SessionDataStore): CartRepository {
        return CartRepositoryImpl(api, session)
    }
}