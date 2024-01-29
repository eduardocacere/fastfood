package br.com.fastfood.adapter.web

import br.com.fastfood.adapter.persistence.enums.OrderStatus
import br.com.fastfood.core.domain.Order
import br.com.fastfood.core.domain.exception.Error
import br.com.fastfood.core.domain.request.OrderStoreRequest
import br.com.fastfood.core.domain.request.ProductRequest
import br.com.fastfood.core.domain.response.OrderDetailResponse
import br.com.fastfood.core.domain.response.OrderResponse
import br.com.fastfood.core.extensions.toOrderDetailResponse
import br.com.fastfood.core.extensions.toResponse
import br.com.fastfood.core.useCase.IOrderUseCase
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order")
class OrderController(
        private val useCase: IOrderUseCase
) {

    @Operation(summary = "Create a new order")
    @ApiResponses(value = [
        ApiResponse(
                responseCode = "200",
                description = "Create client",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = OrderResponse::class))]
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
    fun create(@RequestBody request: OrderStoreRequest): ResponseEntity<OrderResponse> {
        val order = useCase.createStore(request)
        return ResponseEntity.status(HttpStatus.OK).body(order.toResponse())
    }

    @Operation(summary = "Find order by numberCode")
    @ApiResponses(value = [
        ApiResponse(
                responseCode = "200",
                description = "Create client",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = OrderResponse::class))]
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
    @GetMapping("/numberOrder/{numberOrder}")
    fun findByNumberOrder(@PathVariable numberOrder: String): ResponseEntity<OrderDetailResponse> {
        val order = useCase.findByNumberOrder(numberOrder)
        return ResponseEntity.status(HttpStatus.OK).body(order.toOrderDetailResponse())
    }

    @Operation(summary = "Find order by status")
    @ApiResponses(value = [
        ApiResponse(
                responseCode = "200",
                description = "Create client",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = OrderResponse::class))]
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
    @GetMapping("/status/{status}")
    fun findByStatus(@PathVariable status: OrderStatus): ResponseEntity<MutableList<OrderResponse>> {
        val orders = useCase.findByStatus(status)?.map { it.toResponse() }?.toMutableList()
        return ResponseEntity.status(HttpStatus.OK).body(orders)
    }

}