package com.checky.fstory.ui.data.di


import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.checky.fstory.ui.data.datasource.api.AuthApi
import com.checky.fstory.ui.data.datasource.api.CartApi
import com.checky.fstory.ui.data.datasource.api.ProductApi
import com.checky.fstory.ui.data.datasource.preferences.SessionDataStore
import com.checky.fstory.ui.data.repository.AuthRepositoryImpl
import com.checky.fstory.ui.data.repository.CartRepositoryImpl
import com.checky.fstory.ui.data.repository.ProductRepositoryImpl
import com.checky.fstory.ui.domain.repository.AuthRepository
import com.checky.fstory.ui.domain.repository.CartRepository
import com.checky.fstory.ui.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun providesAuthRepository(api: AuthApi, session: SessionDataStore): AuthRepository {
        return AuthRepositoryImpl(api, session)
    }
    @Provides
    fun providesProductRepository(api: ProductApi): ProductRepository {
        return ProductRepositoryImpl(api)
    }

    @Provides
    fun providesCartRepository(api: CartApi,session: SessionDataStore): CartRepository {
        return CartRepositoryImpl(api, session )
    }


    @Provides
    fun provideAuthServices(retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }

    @Provides
    fun provideProductApi(retrofit: Retrofit): ProductApi {
        return retrofit.create(ProductApi::class.java)
    }
    @Provides
    fun provideCartApi(retrofit: Retrofit): CartApi {
        return retrofit.create(CartApi::class.java)
    }


    @Provides
    fun providesAutTest(json: Json): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(json.asConverterFactory("application/json; charset=utf-8".toMediaType()))
            .build()
    }

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = {
                context.preferencesDataStoreFile("session_prefs")
            }
        )
    }

    @Provides
    @Singleton
    fun provideSessionDataStore(dataStore: DataStore<Preferences>): SessionDataStore {
        return SessionDataStore(dataStore)
    }


//    @Provides
//    fun providesRetroFit(json: Json): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl("https://studyin-96f07-default-rtdb.firebaseio.com/")
//            .addConverterFactory(json.asConverterFactory("application/json; charset=utf-8".toMediaType()))
//            .build()
//    }

    @Provides
    fun provideJson(): Json {
        return Json {
            ignoreUnknownKeys = true
            isLenient = true
        }
    }
}