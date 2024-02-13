package br.com.fastfood.infra.repository

import br.com.fastfood.infra.enums.OrderStatus
import br.com.fastfood.infra.port.OrderMongoDBPort
import br.com.fastfood.core.domain.Order
import br.com.fastfood.core.domain.exception.NotFoundException
import br.com.fastfood.infra.extensions.toDocument
import br.com.fastfood.infra.extensions.toDomain
import br.com.fastfood.core.repositoryService.OrderRepositoryService
import org.springframework.stereotype.Repository

@Repository
class OrderRepository(
        private val orderMongoDBPort: OrderMongoDBPort
): OrderRepositoryService {

    override fun create(order: Order): Order {
        return orderMongoDBPort.save(order.toDocument()).toDomain()
    }

    override fun findByNumberOrder(numberOrder: String): Order {
        return orderMongoDBPort.findByNumberOrder(numberOrder)
                ?.toDomain()
                ?:throw NotFoundException("Order not found")
    }

    override fun findByStatus(status: OrderStatus): MutableList<Order> {
        return orderMongoDBPort.findByStatus(mutableListOf(status))
                ?.map { it.toDomain() }
                ?.toMutableList()
                ?: mutableListOf()
    }

    override fun findAllOrderPending(status: MutableList<OrderStatus>): MutableList<Order> {
        return orderMongoDBPort.findByStatusNotIn(status)
                ?.map { it.toDomain() }
                ?.toMutableList()
                ?: mutableListOf()
    }
}