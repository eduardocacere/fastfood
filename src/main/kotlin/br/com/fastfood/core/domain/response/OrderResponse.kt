package br.com.fastfood.core.domain.response

import br.com.fastfood.adapter.persistence.enums.OrderStatus

data class OrderResponse(
        val numberOrder: String,
        val total: Double,
        val status: OrderStatus
)
