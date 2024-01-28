package br.com.fastfood.adapter.web

import br.com.fastfood.core.domain.Order
import br.com.fastfood.core.domain.request.OrderStoreRequest
import br.com.fastfood.core.domain.response.OrderResponse
import br.com.fastfood.core.extensions.toResponse
import br.com.fastfood.core.useCase.IOrderUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order")
class OrderController(
        private val useCase: IOrderUseCase
) {
    @PostMapping
    fun create(@RequestBody request: OrderStoreRequest): ResponseEntity<OrderResponse> {
        val order = useCase.createStore(request)
        return ResponseEntity.status(HttpStatus.OK).body(order.toResponse())
    }

}