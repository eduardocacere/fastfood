package br.com.fastfood.core.domain.response

import br.com.fastfood.infra.enums.OrderStatus
import java.time.LocalDateTime

data class OrderResponse(
        val numberOrder: String,
        val total: Double,
        val status: OrderStatus,
        val dateCreate: LocalDateTime
)
