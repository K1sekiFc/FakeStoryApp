package com.checky.fstory.ui.data.local.entity



import androidx.room.Entity
import androidx.room.PrimaryKey
import com.checky.fstory.ui.data.remote.model.response.ProductResponse

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
fun ProductResponse.toDb(): ProductDbEntity {
    return ProductDbEntity(
        id = id,
        title = title,
        price = price,
        description = description,
        category = category,
        image = image,
        rating = rating.rate
    )
}