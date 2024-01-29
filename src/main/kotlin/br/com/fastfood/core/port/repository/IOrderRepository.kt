package br.com.fastfood.core.port.repository

import br.com.fastfood.adapter.persistence.enums.OrderStatus
import br.com.fastfood.core.domain.Order

interface IOrderRepository {

    fun create(order: Order): Order

    fun findByNumberOrder(numberOrder: String): Order

    fun findByStatus(status: OrderStatus): MutableList<Order>
}