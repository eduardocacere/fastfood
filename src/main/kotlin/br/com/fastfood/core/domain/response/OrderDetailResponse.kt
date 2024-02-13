package br.com.fastfood.core.domain.response

import br.com.fastfood.infra.enums.OrderStatus
import br.com.fastfood.infra.enums.TypeDelivery
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
