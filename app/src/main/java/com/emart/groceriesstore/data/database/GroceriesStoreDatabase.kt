package com.emart.groceriesstore.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.emart.groceriesstore.data.database.dao.CategoryDao
import com.emart.groceriesstore.data.database.dao.LineItemDao
import com.emart.groceriesstore.data.database.dao.OrderDao
import com.emart.groceriesstore.data.database.dao.ProductDao
import com.emart.groceriesstore.data.database.dao.RecipeDao
import com.emart.groceriesstore.data.database.dao.UserDao
import com.emart.groceriesstore.data.database.entities.Category
import com.emart.groceriesstore.data.database.entities.LineItem
import com.emart.groceriesstore.data.database.entities.Order
import com.emart.groceriesstore.data.database.entities.Product
import com.emart.groceriesstore.data.database.entities.Recipe
import com.emart.groceriesstore.data.database.entities.User

@Database(
    entities = [Product::class, LineItem::class, Order::class, Category::class, User::class, Recipe::class],
    version = 1,
    exportSchema = false
)
abstract class GroceriesStoreDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun lineItemDao(): LineItemDao
    abstract fun orderDao(): OrderDao
    abstract fun categoryDao(): CategoryDao
    abstract fun userDao(): UserDao
    abstract fun recipeDao(): RecipeDao
}
