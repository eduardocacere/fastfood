package br.com.fastfood.core.domain

data class OrderItem(

        val name: String,
        val codeProduct: String,
        val quantity: Number,
        val price: Double,
        val observation: String? = null
)
