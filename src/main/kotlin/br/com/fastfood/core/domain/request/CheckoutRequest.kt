package br.com.fastfood.core.domain.request

data class CheckoutRequest(
        val numberOrder: String,
        val card: CardRequest,
        val value: Double
)
