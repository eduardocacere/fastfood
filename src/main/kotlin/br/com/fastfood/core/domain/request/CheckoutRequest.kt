package br.com.fastfood.core.domain.request

import io.swagger.v3.oas.annotations.media.Schema

@Schema(
        title = "Model for a order checkout.",
        description = "Model for a order checkout"
)
data class CheckoutRequest(
        @field:Schema(
                title = "Number of order",
                description = "Unique alphanumeric order identification number",
                example = "1abc2de3-4567-89fg-0123-4g56i7jl890m",
                type = "String"
        )
        val numberOrder: String,

        @field:Schema(
                title = "Credit card object for payment",
                description = "Credit card object for payment",
                type = "CardRequest"
        )
        val card: CardRequest,

        @field:Schema(
                title = "Value to be paid",
                description = "Value to be paid",
                example = "1",
                type = "Double"
        )
        val value: Double
)
