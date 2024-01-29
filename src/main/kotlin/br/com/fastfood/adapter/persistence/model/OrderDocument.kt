package br.com.fastfood.adapter.persistence.model

import br.com.fastfood.adapter.persistence.enums.OrderStatus
import br.com.fastfood.adapter.persistence.enums.TypeDelivery
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

@Document(collection = "order")
data class OrderDocument(
        @Id @Field(name = "_id")
        val id: ObjectId? = null,
        val numberOrder: String,
        val client: ClientDocument? = null,
        val deliveryAddress : AddressDocument? = null,
        val items: MutableList<OrderItemDocument>,
        val total: Double,
        val status: OrderStatus,
        val typeDelivery: TypeDelivery,
        val createAt: LocalDateTime

)
