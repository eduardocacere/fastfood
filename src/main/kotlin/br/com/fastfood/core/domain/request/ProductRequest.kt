package br.com.fastfood.core.domain.request

import br.com.fastfood.adapter.persistence.enums.ProductCategory
import java.time.LocalDateTime

data class ProductRequest(
        val name: String,
        val code: String,
        val price: Double,
        val quantity:  Number,
        val category: ProductCategory,
        val dateValidate: LocalDateTime
)
