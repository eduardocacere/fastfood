package br.com.fastfood.core.useCase

import br.com.fastfood.adapter.persistence.enums.ProductCategory
import br.com.fastfood.adapter.persistence.repository.ProductRepository
import br.com.fastfood.core.domain.Product
import org.springframework.stereotype.Service

@Service
class ProductUseCase(
        private val productRepository: ProductRepository
): IProductUseCase {

    override fun create(product: Product): Product {
        return productRepository.create(product)
    }

    override fun listAll(): MutableList<Product> {
        return productRepository.findByAll()
    }

    override fun findByCode(code: String): Product {
        return productRepository.findByCode(code)
                ?:throw Exception("Produto não encontrado.")
    }

    override fun findByCategory(category: ProductCategory): MutableList<Product> {
        return productRepository.findByCategory(category)
    }

    override fun update(code: String, product: Product) {
        val productDomain = findByCode(code)
        product.id = productDomain.id
        create(product)
    }

    override fun remove(code: String) {
        val productDomain = findByCode(code)
        productRepository.delete(productDomain)
    }
}