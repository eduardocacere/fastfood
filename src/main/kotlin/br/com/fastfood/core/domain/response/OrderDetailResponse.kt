package br.com.fastfood.core.domain.response

import br.com.fastfood.adapter.persistence.enums.OrderStatus
import br.com.fastfood.adapter.persistence.enums.TypeDelivery
import java.time.LocalDateTime

data class OrderDetailResponse(
        val numberOrder: String,
        val client: ClientResponse? = null,
        val total: Double,
        val status: OrderStatus,
        val items: MutableList<OrderItemResponse>,
        val typeDelivery: TypeDelivery,
        val createAt: LocalDateTime
)
