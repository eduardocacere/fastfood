package br.com.fastfood.core.domain.response

data class OrderItemResponse(
        val name: String,
        val codeProduct: String,
        val quantity: Number,
        val price: Double,
        val observation: String? = null
)
