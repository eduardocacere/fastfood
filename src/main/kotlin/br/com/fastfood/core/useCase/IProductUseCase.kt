package br.com.fastfood.core.useCase

import br.com.fastfood.adapter.persistence.enums.ProductCategory
import br.com.fastfood.core.domain.Product

interface IProductUseCase {

    fun create(product: Product): Product

    fun listAll(): MutableList<Product>

    fun findByCode(code: String): Product

    fun findByCategory(category: ProductCategory): MutableList<Product>

    fun update(code: String, product: Product)

    fun remove(code: String)
}