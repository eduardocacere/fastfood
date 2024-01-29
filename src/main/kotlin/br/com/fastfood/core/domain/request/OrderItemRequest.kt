package br.com.fastfood.core.domain.request

import io.swagger.v3.oas.annotations.media.Schema

@Schema(
        title = "Model for a order items.",
        description = "Model for a order items."
)
data class OrderItemRequest(

        @field:Schema(
                title = "Code of product",
                description = "Code of product",
                example = "001",
                type = "String"
        )
        val codeProduct: String,

        @field:Schema(
                title = "Quantity of product",
                description = "Quantity of product",
                example = "1",
                type = "int"
        )
        val quantity: Number,

        @field:Schema(
                title = "Observation of product",
                description = "Observation of product",
                example = "Snack without onion",
                type = "String"
        )
        val observation: String? = null
)
