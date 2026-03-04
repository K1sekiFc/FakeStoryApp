package com.checky.fstory.ui.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.checky.fstory.ui.data.local.entity.ProductDbEntity
import com.checky.fstory.ui.data.local.dao.ProductDao

@Database(
    entities = [ProductDbEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase(){  abstract fun productDao(): ProductDao
}