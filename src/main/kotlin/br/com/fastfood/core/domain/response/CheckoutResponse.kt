package br.com.fastfood.core.domain.response

import br.com.fastfood.adapter.persistence.enums.OrderStatus

data class CheckoutResponse(
        val numberCheckout: String,
        val status: OrderStatus
)
