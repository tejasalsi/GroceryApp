package com.emart.groceriesstore.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.emart.groceriesstore.utilities.LINE_ITEM_TABLE

@Entity(tableName = LINE_ITEM_TABLE)
data class LineItem(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "lineItemId")
    val id: Long = 0,

    @ColumnInfo(name = "productId")
    val productId: String,

    @ColumnInfo(name = "orderId")
    val orderId: String,

    @ColumnInfo(name = "quantity")
    var quantity: Int,

    @ColumnInfo(name = "subtotal")
    var subtotal: Double

)