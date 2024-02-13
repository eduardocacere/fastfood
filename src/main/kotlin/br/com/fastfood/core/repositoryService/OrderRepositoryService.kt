package br.com.fastfood.core.repositoryService

import br.com.fastfood.infra.enums.OrderStatus
import br.com.fastfood.core.domain.Order

interface OrderRepositoryService {

    fun create(order: Order): Order

    fun findByNumberOrder(numberOrder: String): Order

    fun findByStatus(status: OrderStatus): MutableList<Order>
}