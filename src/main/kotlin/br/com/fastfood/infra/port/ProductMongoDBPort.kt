package br.com.fastfood.infra.port

import br.com.fastfood.infra.enums.ProductCategory
import br.com.fastfood.infra.model.ProductDocument
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductMongoDBPort: MongoRepository<ProductDocument, ObjectId> {

    fun findByCode(code: String): ProductDocument?

    fun findByCategory(category: ProductCategory): MutableList<ProductDocument>?
}