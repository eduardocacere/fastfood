package br.com.fastfood.core.domain.request

import br.com.fastfood.adapter.persistence.enums.TypeDelivery
import br.com.fastfood.core.domain.Address
import io.swagger.v3.oas.annotations.media.Schema

@Schema(
        title = "Model for create a order",
        description = "Model for create a order."
)
data class OrderStoreRequest(
        @field:Schema(
                title = "Object to define a customer",
                description = "In cases where the customer does not exist, this field does not need to be sent",
                type = "ClientOrderRequest"
        )
        val client: ClientOrderRequest? = null,

        @field:Schema(
                title = "List of objects to define order items",
                description = "List of objects to define order items",
                type = "MutableList<OrderItemRequest>",
        )
        val items: MutableList<OrderItemRequest>,

        @field:Schema(
                title = "Objects to define the order delivery type",
                description = "Objects to define the order delivery type",
                type = "TypeDelivery",
                example = "EAT_HERE"
        )
        val typeDelivery: TypeDelivery
)



