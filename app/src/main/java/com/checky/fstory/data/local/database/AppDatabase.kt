package com.checky.fstory.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.checky.fstory.data.local.dao.ProductDao
import com.checky.fstory.data.local.entityDB.ProductDbEntity

@Database(
    entities = [ProductDbEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase(){  abstract fun productDao(): ProductDao
}