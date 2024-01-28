package br.com.fastfood.adapter.persistence.port

import br.com.fastfood.adapter.persistence.enums.OrderStatus
import br.com.fastfood.adapter.persistence.model.OrderDocument
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface OrderMongoDBPort: MongoRepository<OrderDocument, ObjectId> {

    fun findByNumberOrder(numberOrder: String): OrderDocument?

    fun findByStatus(status: OrderStatus): MutableList<OrderDocument>?


}