package br.com.fastfood.core.domain

import br.com.fastfood.adapter.persistence.enums.ProductCategory
import org.bson.types.ObjectId
import java.time.LocalDateTime

data class Product(
        var id: ObjectId? = null,
        val name: String,
        val code: String,
        val price: Double,
        val quantity:  Number,
        val category: ProductCategory,
        val dateValidate: LocalDateTime
)
