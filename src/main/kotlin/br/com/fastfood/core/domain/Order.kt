package br.com.fastfood.core.domain

import br.com.fastfood.adapter.persistence.enums.OrderStatus
import br.com.fastfood.adapter.persistence.enums.TypeDelivery
import org.bson.types.ObjectId
import java.time.LocalDateTime

data class Order (
        val id: ObjectId? = null,
        var numberOrder: String,
        val client: Client? = null,
        val deliveryAddress : Address? = null,
        val items: MutableList<OrderItem>,
        val total: Double,
        var status: OrderStatus,
        val typeDelivery: TypeDelivery,
        val createAt: LocalDateTime
)