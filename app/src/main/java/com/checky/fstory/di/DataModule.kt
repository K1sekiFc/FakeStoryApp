//package com.checky.fstory.di


import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.checky.fstory.ui.data.remote.api.AuthApi
import com.checky.fstory.ui.data.remote.api.CartApi
import com.checky.fstory.ui.data.remote.api.ProductApi
import com.checky.fstory.ui.data.local.dao.ProductDao
import com.checky.fstory.ui.data.local.datastore.SessionDataStore
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
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//object DataModule {
//

//    @Provides
//    @Singleton
//    fun provideDatabase(
//        @ApplicationContext context: Context
//    ): AppDatabase {
//        return Room.databaseBuilder(
//            context,
//            AppDatabase::class.java,
//            "fstory_db"
//        ).build()
//    }
//
//    @Provides
//    fun provideProductDao(
//        database: AppDatabase
//    ): ProductDao {
//        return database.productDao()
//    }

//    @Provides
//    fun providesAuthRepository(api: AuthApi, session: SessionDataStore): AuthRepository {
//        return AuthRepositoryImpl(api, session)
//    }
//    @Provides
//    fun providesProductRepository(api: ProductApi,dao: ProductDao): ProductRepository {
//        return ProductRepositoryImpl(api,dao)
//    }
//
//    @Provides
//    fun providesCartRepository(api: CartApi,session: SessionDataStore): CartRepository {
//        return CartRepositoryImpl(api, session )
//    }
//

//    @Provides
//    @Singleton
//    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
//        return PreferenceDataStoreFactory.create(
//            produceFile = {
//                context.preferencesDataStoreFile("session_prefs")
//            }
//        )
//    }
//
//    @Provides
//    @Singleton
//    fun provideSessionDataStore(dataStore: DataStore<Preferences>): SessionDataStore {
//        return SessionDataStore(dataStore)
//    }


//    @Provides
//    fun providesFirebaseURL(json: Json): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl("https://studyin-96f07-default-rtdb.firebaseio.com/")
//            .addConverterFactory(json.asConverterFactory("application/json; charset=utf-8".toMediaType()))
//            .build()
//    }
//
//    @Provides
//    fun provideJson(): Json {
//        return Json {
//            ignoreUnknownKeys = true
//            isLenient = true
//        }
//    }
///}