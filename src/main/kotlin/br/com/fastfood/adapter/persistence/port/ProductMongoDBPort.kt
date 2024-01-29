package br.com.fastfood.adapter.persistence.port

import br.com.fastfood.adapter.persistence.enums.ProductCategory
import br.com.fastfood.adapter.persistence.model.ClientDocument
import br.com.fastfood.adapter.persistence.model.ProductDocument
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductMongoDBPort: MongoRepository<ProductDocument, ObjectId> {

    fun findByCode(code: String): ProductDocument?

    fun findByCategory(category: ProductCategory): MutableList<ProductDocument>?
}