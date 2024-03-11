package br.com.fastfood.infra.repository

import br.com.fastfood.infra.enums.ProductCategory
import br.com.fastfood.infra.port.ProductMongoDBPort
import br.com.fastfood.core.domain.Product
import br.com.fastfood.infra.extensions.toDocument
import br.com.fastfood.infra.extensions.toDomain
import br.com.fastfood.core.repositoryService.ProductRepositoryService
import org.springframework.stereotype.Repository

@Repository
class ProductRepository(
        private val productMongoDBPort: ProductMongoDBPort
): ProductRepositoryService {


    override fun create(product: Product): Product {
        return productMongoDBPort.save(product.toDocument()).toDomain()
    }

    override fun findByCategory(category: ProductCategory): MutableList<Product> {
        return productMongoDBPort.findByCategory(category)
                ?.map { it.toDomain() }
                ?.toMutableList()
                ?: mutableListOf()
    }

    override fun findByAll(): MutableList<Product> {
        return productMongoDBPort.findAll().map { it.toDomain() }.toMutableList()
    }

    override fun findByCode(code: String): Product? {
        return productMongoDBPort.findByCode(code)?.toDomain()
    }

    override fun delete(product: Product) {
        productMongoDBPort.delete(product.toDocument())
    }
}