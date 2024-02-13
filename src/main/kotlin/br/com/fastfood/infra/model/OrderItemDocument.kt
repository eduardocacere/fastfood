package br.com.fastfood.infra.model

data class OrderItemDocument(

        val name: String,
        val codeProduct: String,
        val quantity: Number,
        val price: Double

)
