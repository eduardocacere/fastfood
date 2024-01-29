package br.com.fastfood.core.extensions

import br.com.fastfood.adapter.persistence.model.OrderDocument
import br.com.fastfood.adapter.persistence.model.OrderItemDocument
import br.com.fastfood.core.domain.Order
import br.com.fastfood.core.domain.OrderItem
import br.com.fastfood.core.domain.response.OrderDetailResponse
import br.com.fastfood.core.domain.response.OrderItemResponse
import br.com.fastfood.core.domain.response.OrderResponse

fun Order.toDocument(): OrderDocument =
        OrderDocument(
                id = id,
                numberOrder = numberOrder,
                client = client?.toDocument(),
                deliveryAddress = deliveryAddress?.toDocument(),
                items = items.map { it.toDocument() }.toMutableList(),
                total = total,
                status = status,
                typeDelivery = typeDelivery,
                createAt = createAt
        )

fun OrderDocument.toDomain(): Order =
        Order(
                id = id,
                numberOrder = numberOrder,
                client = client?.toDomain(),
                deliveryAddress = deliveryAddress?.toDomain(),
                items = items.map { it.toDomain() }.toMutableList(),
                total = total,
                status = status,
                typeDelivery = typeDelivery,
                createAt = createAt
        )

fun OrderItem.toDocument(): OrderItemDocument =
        OrderItemDocument(
                name = name,
                codeProduct = codeProduct,
                quantity = quantity,
                price = price
        )

fun OrderItemDocument.toDomain(): OrderItem =
        OrderItem(
                name = name,
                codeProduct = codeProduct,
                quantity = quantity,
                price = price
        )

fun Order.toResponse(): OrderResponse =
        OrderResponse(
                numberOrder = numberOrder,
                total = total,
                status = status
        )

fun Order.toOrderDetailResponse(): OrderDetailResponse =
        OrderDetailResponse(
                numberOrder = numberOrder,
                client = client?.toResponse(),
                total = total,
                status = status,
                items = items.map { it.toOrderItemResponse() }.toMutableList(),
                typeDelivery = typeDelivery,
                createAt = createAt
        )

fun OrderItem.toOrderItemResponse(): OrderItemResponse =
        OrderItemResponse(
                name = name,
                codeProduct = codeProduct,
                quantity = quantity,
                price = price
        )

