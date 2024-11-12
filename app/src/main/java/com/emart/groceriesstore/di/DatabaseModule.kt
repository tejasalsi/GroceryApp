package com.emart.groceriesstore.di

import android.content.Context
import androidx.room.Room
import com.emart.groceriesstore.data.database.GroceriesStoreDatabase
import com.emart.groceriesstore.data.database.dao.CategoryDao
import com.emart.groceriesstore.data.database.dao.LineItemDao
import com.emart.groceriesstore.data.database.dao.OrderDao
import com.emart.groceriesstore.data.database.dao.ProductDao
import com.emart.groceriesstore.data.database.dao.RecipeDao
import com.emart.groceriesstore.data.database.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): GroceriesStoreDatabase {
        return Room.databaseBuilder(
            appContext,
            GroceriesStoreDatabase::class.java,
            "groceries_store.db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideProductDao(database: GroceriesStoreDatabase): ProductDao {
        return database.productDao()
    }

    @Provides
    fun provideLineItemDao(database: GroceriesStoreDatabase): LineItemDao {
        return database.lineItemDao()
    }

    @Provides
    fun provideOrderDao(database: GroceriesStoreDatabase): OrderDao {
        return database.orderDao()
    }

    @Provides
    fun provideCategoryDao(database: GroceriesStoreDatabase): CategoryDao {
        return database.categoryDao()
    }

    @Provides
    fun provideUserdao(database: GroceriesStoreDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    fun provideRecipeDao(database: GroceriesStoreDatabase): RecipeDao {
        return database.recipeDao()
    }
}
