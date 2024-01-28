package br.com.fastfood.adapter.persistence.repository

import br.com.fastfood.adapter.persistence.enums.OrderStatus
import br.com.fastfood.adapter.persistence.port.OrderMongoDBPort
import br.com.fastfood.core.domain.Order
import br.com.fastfood.core.domain.exception.NotFoundException
import br.com.fastfood.core.extensions.toDocument
import br.com.fastfood.core.extensions.toDomain
import br.com.fastfood.core.port.repository.IOrderRepository
import org.springframework.stereotype.Repository

@Repository
class OrderRepository(
        private val orderMongoDBPort: OrderMongoDBPort
): IOrderRepository {

    override fun create(order: Order): Order {
        return orderMongoDBPort.save(order.toDocument()).toDomain()
    }

    override fun findByNumberOrder(numberOrder: String): Order {
        return orderMongoDBPort.findByNumberOrder(numberOrder)
                ?.toDomain()
                ?:throw NotFoundException("Order not found")
    }

    override fun findByStatus(status: OrderStatus): MutableList<Order> {
        return orderMongoDBPort.findByStatus(status)
                ?.map { it.toDomain() }
                ?.toMutableList()
                ?: mutableListOf()
    }
}