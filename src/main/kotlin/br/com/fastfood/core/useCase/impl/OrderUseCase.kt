package br.com.fastfood.core.useCase.impl

import br.com.fastfood.infra.enums.OrderStatus
import br.com.fastfood.core.domain.Client
import br.com.fastfood.core.domain.Order
import br.com.fastfood.core.domain.OrderItem
import br.com.fastfood.core.domain.exception.FastFoodException
import br.com.fastfood.core.domain.exception.NotFoundException
import br.com.fastfood.core.domain.request.ClientOrderRequest
import br.com.fastfood.core.domain.request.OrderStoreRequest
import br.com.fastfood.core.domain.response.OrderQueueResponse
import br.com.fastfood.core.domain.response.OrderResponse
import br.com.fastfood.core.repositoryService.OrderRepositoryService
import br.com.fastfood.core.useCase.IOrderUseCase
import br.com.fastfood.infra.extensions.toResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import java.time.LocalDateTime.now
import java.util.*

@Service
class OrderUseCase(
        private val orderRepository: OrderRepositoryService,
        private val clientUseCase: ClientUseCase,
        private val productUseCase: ProductUseCase
): IOrderUseCase {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    override fun createStore(request: OrderStoreRequest): Order {
        logger.info("Create Order for Store - $request")

        val client: Client? = findOrCreateClient(request.client)

        if(request.items.isEmpty()) {
            throw FastFoodException(message = "Item List cannot be empty", code = HttpStatus.BAD_REQUEST)
        }

        val orderItems = buildOrderItems(request)
        val totalOrderItem: Double = calculateTotal(orderItems)

        val order = buildOrder(client, orderItems, totalOrderItem, request)

        val orderCreated = orderRepository.create(order)

        return orderCreated

    }

    override fun createWeb(orderStoreRequest: OrderStoreRequest): Order {
        TODO("Not yet implemented")
    }

    override fun findByNumberOrder(numberOrder: String): Order {
        return orderRepository.findByNumberOrder(numberOrder)
    }

    override fun findByStatus(status: OrderStatus): MutableList<Order>? {
        return orderRepository.findByStatus(status)
    }

    override fun update(order: Order): Order {
        if(order.id == null) {
            throw NotFoundException("Order not found for update")
        }
        return orderRepository.create(order)
    }

    override fun findOrderByFlow(): OrderQueueResponse {
        val orders = orderRepository.findAllOrderPending( mutableListOf(OrderStatus.FINISHED, OrderStatus.PAYMENT_REFUSED))

        val orderQueue: OrderQueueResponse = OrderQueueResponse()

        orderQueue.done = buildOrderByStatus(orders, OrderStatus.DONE)
        orderQueue.receveid = buildOrderByStatus(orders, OrderStatus.RECEIVED)
        orderQueue.inPreparation = buildOrderByStatus(orders, OrderStatus.IN_PREPARATION)


        return orderQueue
    }

    override fun updateStatus(numberOrder: String, status: OrderStatus): Order {
        val order = findByNumberOrder(numberOrder)

        order.status = status
        val orderUpdated = update(order)

        return orderUpdated


    }

    private fun buildOrderItems(request: OrderStoreRequest) = request.items.map {
        val product = productUseCase.findByCode(it.codeProduct)
        val orderItem = OrderItem(
                name = product.name,
                codeProduct = it.codeProduct,
                quantity = it.quantity,
                price = product.price,
                observation = it.observation

        )
        orderItem
    }.toMutableList()

    private fun buildOrder(client: Client?, orderItems: MutableList<OrderItem>, totalOrderItem: Double, request: OrderStoreRequest) =
            Order(
                    numberOrder = UUID.randomUUID().toString(),
                    client = client,
                    items = orderItems,
                    total = totalOrderItem,
                    status = OrderStatus.NEW,
                    typeDelivery = request.typeDelivery,
                    createAt = now()
            )

    private fun calculateTotal(orderItems: MutableList<OrderItem>): Double {
        var total: Double = 0.0
        orderItems.forEach {
            total += (it.quantity).toLong() * (it.price)
        }
        return total
    }

    private fun findOrCreateClient(client: ClientOrderRequest?): Client? {
        if(client?.email.isNullOrEmpty().not()) {
            return clientUseCase.findOrCreate(client)
        }
        return null
    }

    private fun buildOrderByStatus(orders: MutableList<Order>, status: OrderStatus): MutableList<OrderResponse> {
        return orders
                .filter { it.status.equals(status) }
                .map { it.toResponse() }
                .sortedByDescending { it.dateCreate }
                .toMutableList()
    }
}