package com.emart.groceriesstore.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.emart.groceriesstore.data.database.entities.Order
import com.emart.groceriesstore.data.database.entities.OrderWithLineItems
import com.emart.groceriesstore.utilities.ORDER_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {
    @Insert
    fun insert(order: Order)

    @Update
    fun update(order: Order)

    @Query("DELETE FROM `$ORDER_TABLE`")
    fun clear()

    @Transaction
    @Query("SELECT * FROM `$ORDER_TABLE` WHERE orderId = :id")
    fun getById(id: String): OrderWithLineItems

    @Query("SELECT EXISTS(SELECT 1 FROM `$ORDER_TABLE` WHERE status = :status LIMIT 1)")
    fun isCartExisted(status: String): Flow<Boolean>

    @Query("SELECT * FROM `$ORDER_TABLE` WHERE status = :status LIMIT 1")
    fun getOrderInCart(status: String): Flow<Order>

    @Query("SELECT * FROM `$ORDER_TABLE` WHERE status = :status  LIMIT 1 ")
    fun getCart(status: String): Flow<Order>

    @Transaction
    @Query("SELECT * FROM `$ORDER_TABLE` WHERE status = :status  LIMIT 1 ")
    fun getCartWithLineItems(status: String): Flow<OrderWithLineItems?>
}