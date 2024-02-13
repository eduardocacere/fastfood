package br.com.fastfood.core.useCase

import br.com.fastfood.infra.enums.OrderStatus
import br.com.fastfood.core.domain.Order
import br.com.fastfood.core.domain.request.OrderStoreRequest
import br.com.fastfood.core.domain.response.OrderQueueResponse


interface IOrderUseCase {

    fun createStore(request: OrderStoreRequest): Order

    fun createWeb(orderStoreRequest: OrderStoreRequest): Order

    fun findByNumberOrder(numberOrder: String): Order

    fun findByStatus(status: OrderStatus): MutableList<Order>?

    fun findOrderByFlow(): OrderQueueResponse

    fun update(order: Order): Order
}