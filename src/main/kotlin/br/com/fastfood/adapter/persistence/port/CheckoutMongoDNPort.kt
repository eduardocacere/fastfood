package br.com.fastfood.adapter.persistence.port

import br.com.fastfood.adapter.persistence.model.CheckoutDocument
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface CheckoutMongoDNPort: MongoRepository<CheckoutDocument, ObjectId> {

    fun findByNumberCheckout(numberCheckout: String): CheckoutDocument?

    fun existsByOrderNumberOrder(numberOrder: String): Boolean
}