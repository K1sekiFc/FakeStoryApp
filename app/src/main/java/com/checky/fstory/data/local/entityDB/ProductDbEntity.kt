package com.checky.fstory.data.local.entityDB



import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductDbEntity (
    @PrimaryKey

    val id : Int,
    val title: String,
    val price : Float,
    val description: String,
    val category: String,
    val image : String,

    val rating: Double
)
