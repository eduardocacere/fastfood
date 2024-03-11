package br.com.fastfood.core.repositoryService

import br.com.fastfood.infra.enums.ProductCategory
import br.com.fastfood.core.domain.Product

interface ProductRepositoryService {

    fun create(product: Product): Product

    fun findByCategory(category: ProductCategory): MutableList<Product>

    fun findByAll(): MutableList<Product>

    fun findByCode(code: String): Product?

    fun delete(product: Product)

}