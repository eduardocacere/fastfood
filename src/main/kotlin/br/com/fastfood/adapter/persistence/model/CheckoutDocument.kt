package br.com.fastfood.adapter.persistence.model

import br.com.fastfood.adapter.persistence.enums.OrderStatus
import br.com.fastfood.adapter.persistence.enums.TypePayment
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

@Document(collection = "checkout")
data class CheckoutDocument(
        @Id @Field(name = "_id")
        val id: ObjectId? = null,
        val order: OrderDocument,
        val numberCheckout: String,
        val typePayment: TypePayment,
        val value: Double,
        val card: CardDocument,
        val status: OrderStatus,
        val createAt: LocalDateTime
)
