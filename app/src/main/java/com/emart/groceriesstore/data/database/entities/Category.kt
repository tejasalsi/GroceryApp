package com.emart.groceriesstore.data.database.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.emart.groceriesstore.domain.models.CategoryModel
import com.emart.groceriesstore.utilities.CATEGORY_TABLE

@Entity(tableName = CATEGORY_TABLE)
data class Category(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "image")
    val image: String?
)

fun List<Category>.asDomainModel(): List<CategoryModel> {
    return map {
        CategoryModel(
            id = it.id,
            name = it.name,
            image = it.image
        )
    }
}
