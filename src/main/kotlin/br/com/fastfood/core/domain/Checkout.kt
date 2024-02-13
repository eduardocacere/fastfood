package br.com.fastfood.core.domain

import br.com.fastfood.infra.enums.OrderStatus
import br.com.fastfood.infra.enums.TypePayment
import org.bson.types.ObjectId
import java.time.LocalDateTime

data class Checkout(
        val id: ObjectId? = null,
        val order: Order,
        val numberCheckout: String,
        val typePayment: TypePayment,
        val card: Card,
        val value: Double,
        val status: OrderStatus,
        val createAt: LocalDateTime

)
