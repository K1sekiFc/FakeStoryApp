package com.checky.fstory.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.checky.fstory.data.local.entityDB.ProductDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface  ProductDao {
    @Query("SELECT * FROM products")
    fun getAllProducts(): Flow<List<ProductDbEntity>>

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertProducts(products: List<ProductDbEntity>)

    @Query("DELETE FROM products")
    suspend fun clearProducts()
}