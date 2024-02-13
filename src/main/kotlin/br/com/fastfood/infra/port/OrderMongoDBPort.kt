package br.com.fastfood.infra.port

import br.com.fastfood.infra.enums.OrderStatus
import br.com.fastfood.infra.model.OrderDocument
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface OrderMongoDBPort: MongoRepository<OrderDocument, ObjectId> {

    fun findByNumberOrder(numberOrder: String): OrderDocument?

    fun findByStatus(status: OrderStatus): MutableList<OrderDocument>?


}