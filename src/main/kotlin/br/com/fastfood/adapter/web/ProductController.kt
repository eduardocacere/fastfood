package br.com.fastfood.adapter.web

import br.com.fastfood.adapter.persistence.enums.ProductCategory
import br.com.fastfood.core.domain.exception.Error
import br.com.fastfood.core.domain.request.ClientRequest
import br.com.fastfood.core.domain.request.ProductRequest
import br.com.fastfood.core.domain.response.ProductResponse
import br.com.fastfood.core.extensions.toDomain
import br.com.fastfood.core.extensions.toResponse
import br.com.fastfood.core.useCase.IProductUseCase
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
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

    @Operation(summary = "Create a new product")
    @ApiResponses(value = [
        ApiResponse(
                responseCode = "200",
                description = "Create client",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = ProductResponse::class))]
        ),
        ApiResponse(
                responseCode = "400",
                description = "An error occurred during processing",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = Error::class))]
        ),
        ApiResponse(
                responseCode = "404",
                description = "Not found",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = Error::class))]
        )
    ])
    @PostMapping
    fun create(@RequestBody @Valid productRequest: ProductRequest): ResponseEntity<ProductResponse> {

        val response = useCase.create(productRequest.toDomain()).toResponse()
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }


    @Operation(summary = "Find all product")
    @ApiResponses(value = [
        ApiResponse(
                responseCode = "200",
                description = "Create client",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = ProductResponse::class))]
        ),
        ApiResponse(
                responseCode = "400",
                description = "An error occurred during processing",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = Error::class))]
        ),
        ApiResponse(
                responseCode = "404",
                description = "Not found",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = Error::class))]
        )
    ])
    @GetMapping
    fun findAll(): ResponseEntity<MutableList<ProductResponse>> {
        val products: MutableList<ProductResponse> = useCase.listAll().map { it.toResponse() }.toMutableList()
        return ResponseEntity.status(HttpStatus.OK).body(products)
    }

    @Operation(summary = "Find product by code")
    @ApiResponses(value = [
        ApiResponse(
                responseCode = "200",
                description = "Create client",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = ProductResponse::class))]
        ),
        ApiResponse(
                responseCode = "400",
                description = "An error occurred during processing",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = Error::class))]
        ),
        ApiResponse(
                responseCode = "404",
                description = "Not found",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = Error::class))]
        )
    ])
    @GetMapping("/code/{code}")
    fun findCode(@PathVariable code: String): ResponseEntity<ProductResponse> {
        val product = useCase.findByCode(code)
        return ResponseEntity.status(HttpStatus.OK).body(product.toResponse())
    }

    @Operation(summary = "Find product by category")
    @ApiResponses(value = [
        ApiResponse(
                responseCode = "200",
                description = "Create client",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = ProductResponse::class))]
        ),
        ApiResponse(
                responseCode = "400",
                description = "An error occurred during processing",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = Error::class))]
        ),
        ApiResponse(
                responseCode = "404",
                description = "Not found",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = Error::class))]
        )
    ])
    @GetMapping("/category/{category}")
    fun findCategory(@PathVariable category: ProductCategory): ResponseEntity<MutableList<ProductResponse>> {
        val products: MutableList<ProductResponse> = useCase.findByCategory(category).map { it.toResponse() }.toMutableList()
        return ResponseEntity.status(HttpStatus.OK).body(products)
    }

    @Operation(summary = "Update product by code")
    @ApiResponses(value = [
        ApiResponse(
                responseCode = "200",
                description = "Create client",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = ProductResponse::class))]
        ),
        ApiResponse(
                responseCode = "400",
                description = "An error occurred during processing",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = Error::class))]
        ),
        ApiResponse(
                responseCode = "404",
                description = "Not found",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = Error::class))]
        )
    ])
    @PutMapping("/{code}")
    fun update(@PathVariable code: String, @RequestBody productRequest: ProductRequest): ResponseEntity<Unit> {
        useCase.update(code, productRequest.toDomain())
        return ResponseEntity.status(HttpStatus.OK).build()
    }

    @Operation(summary = "Remove produtct by code")
    @ApiResponses(value = [
        ApiResponse(
                responseCode = "200",
                description = "Create client",
                content = [Content(mediaType = "application/json")]
        ),
        ApiResponse(
                responseCode = "400",
                description = "An error occurred during processing",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = Error::class))]
        ),
        ApiResponse(
                responseCode = "404",
                description = "Not found",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = Error::class))]
        )
    ])
    @DeleteMapping("/{code}")
    fun delete(@PathVariable code: String): ResponseEntity<Unit> {
        useCase.remove(code)
        return ResponseEntity.status(HttpStatus.OK).build()
    }



}