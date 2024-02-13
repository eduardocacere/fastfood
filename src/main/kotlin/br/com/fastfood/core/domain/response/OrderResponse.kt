package br.com.fastfood.core.domain.response

import br.com.fastfood.infra.enums.OrderStatus

data class OrderResponse(
        val numberOrder: String,
        val total: Double,
        val status: OrderStatus
)
