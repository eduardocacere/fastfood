package br.com.fastfood.core.domain.response

import br.com.fastfood.infra.enums.OrderStatus

data class CheckoutResponse(
        val numberCheckout: String,
        val status: OrderStatus
)
