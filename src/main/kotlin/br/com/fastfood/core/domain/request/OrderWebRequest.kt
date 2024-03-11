package br.com.fastfood.core.domain.request

import br.com.fastfood.infra.enums.TypeDelivery
import br.com.fastfood.core.domain.Address

data class OrderWebRequest(
        val emailClient: String? = null,
        val deliveryAddress : Address? = null,
        val items: MutableList<OrderItemRequest>,
        val typeDelivery: TypeDelivery
)



