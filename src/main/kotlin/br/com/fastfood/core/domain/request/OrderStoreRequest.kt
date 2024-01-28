package br.com.fastfood.core.domain.request

import br.com.fastfood.adapter.persistence.enums.TypeDelivery
import br.com.fastfood.core.domain.Address

data class OrderStoreRequest(
        val client: ClientOrderRequest? = null,
        val items: MutableList<OrderItemRequest>,
        val typeDelivery: TypeDelivery
)



