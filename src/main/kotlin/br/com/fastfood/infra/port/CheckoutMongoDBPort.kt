package br.com.fastfood.infra.port

import br.com.fastfood.infra.model.CheckoutDocument
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface CheckoutMongoDBPort: MongoRepository<CheckoutDocument, ObjectId> {

    fun findByNumberCheckout(numberCheckout: String): CheckoutDocument?

    fun existsByOrderNumberOrder(numberOrder: String): Boolean
}