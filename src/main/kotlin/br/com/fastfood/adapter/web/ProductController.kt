package br.com.fastfood.adapter.web

import br.com.fastfood.adapter.persistence.enums.ProductCategory
import br.com.fastfood.core.domain.request.ProductRequest
import br.com.fastfood.core.domain.response.ProductResponse
import br.com.fastfood.core.extensions.toDomain
import br.com.fastfood.core.extensions.toResponse
import br.com.fastfood.core.useCase.IProductUseCase
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/product")
class ProductController(
private val useCase: IProductUseCase
)
{

    @PostMapping
    fun create(@RequestBody @Valid productRequest: ProductRequest): ResponseEntity<ProductResponse> {

        val response = useCase.create(productRequest.toDomain()).toResponse()
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }

    @GetMapping
    fun findAll(): ResponseEntity<MutableList<ProductResponse>> {
        val products: MutableList<ProductResponse> = useCase.listAll().map { it.toResponse() }.toMutableList()
        return ResponseEntity.status(HttpStatus.OK).body(products)
    }

    @GetMapping("/code/{code}")
    fun findCode(@PathVariable code: String): ResponseEntity<ProductResponse> {
        val product = useCase.findByCode(code)
        return ResponseEntity.status(HttpStatus.OK).body(product.toResponse())
    }

    @GetMapping("/category/{category}")
    fun findCategory(@PathVariable category: ProductCategory): ResponseEntity<MutableList<ProductResponse>> {
        val products: MutableList<ProductResponse> = useCase.findByCategory(category).map { it.toResponse() }.toMutableList()
        return ResponseEntity.status(HttpStatus.OK).body(products)
    }

    @PutMapping("/{code}")
    fun update(@PathVariable code: String, @RequestBody productRequest: ProductRequest): ResponseEntity<Unit> {
        useCase.update(code, productRequest.toDomain())
        return ResponseEntity.status(HttpStatus.OK).build()
    }

    @DeleteMapping("/{code}")
    fun delete(@PathVariable code: String): ResponseEntity<Unit> {
        useCase.remove(code)
        return ResponseEntity.status(HttpStatus.OK).build()
    }



}