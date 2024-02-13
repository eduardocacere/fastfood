package br.com.fastfood.core.domain.request

import br.com.fastfood.infra.enums.ProductCategory
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

@Schema(
        description = "Model for a product."
)
data class ProductRequest(
        @field:NotBlank(message = "Name must not be blank")
        @field:Schema(
                description = "Name of product",
                example = "Batata Frita",
                type = "String"
        )
        val name: String,

        @field:NotBlank(message = "code must not be blank")
        @field:Schema(
                description = "code of product",
                example = "001",
                type = "String"
        )
        val code: String,

        @field:NotBlank(message = "price must not be blank")
        @field:Schema(
                description = "Price of product",
                example = "1.1",
                type = "Double"
        )
        val price: Double,

        @field:NotBlank(message = "quantity must not be blank")
        @field:Schema(
                description = "Quantity of product",
                example = "1",
                type = "int"
        )
        val quantity:  Number,

        @field:NotBlank(message = "category must not be blank")
        @field:Schema(
                description = "category of product",
                example = "SNACK",
                type = "ProductCategory"
        )
        val category: ProductCategory,

        @field:NotBlank(message = "dateValidate must not be blank")
        @field:Schema(
                description = "Expiry date of a product",
                example = "01-01-2024",
                type = "LocalDateTime"
        )
        val dateValidate: LocalDateTime
)
