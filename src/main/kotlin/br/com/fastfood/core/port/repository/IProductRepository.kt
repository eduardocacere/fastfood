package br.com.fastfood.core.port.repository

import br.com.fastfood.adapter.persistence.enums.ProductCategory
import br.com.fastfood.core.domain.Product

interface IProductRepository {

    fun create(product: Product): Product

    fun findByCategory(category: ProductCategory): MutableList<Product>

    fun findByAll(): MutableList<Product>

    fun findByCode(code: String): Product?

    fun delete(product: Product)

}