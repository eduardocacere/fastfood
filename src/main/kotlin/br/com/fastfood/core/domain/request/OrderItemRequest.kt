package br.com.fastfood.core.domain.request

data class OrderItemRequest(
        val codeProduct: String,
        val quantity: Number,
        val observation: String? = null
)
