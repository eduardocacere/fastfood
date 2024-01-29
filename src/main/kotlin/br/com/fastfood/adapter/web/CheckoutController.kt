package br.com.fastfood.adapter.web

import br.com.fastfood.core.domain.request.CheckoutRequest
import br.com.fastfood.core.domain.response.CheckoutResponse
import br.com.fastfood.core.extensions.toResponse
import br.com.fastfood.core.useCase.IUseCaseCheckout
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/checkout")
class CheckoutController(
    private val useCase: IUseCaseCheckout
) {

    @PostMapping
    fun checkout(@RequestBody checkoutRequest: CheckoutRequest): ResponseEntity<CheckoutResponse> {
        val checkout = useCase.checkout(checkoutRequest)
        return ResponseEntity.status(HttpStatus.MULTI_STATUS).body(checkout.toResponse())

    }

    @GetMapping("/numberCheckout/{numberCheckout}")
    fun findByNumberCheckout(@PathVariable numberCheckout: String): ResponseEntity<CheckoutResponse> {
        val checkout = useCase.findByNumberCheckout(numberCheckout)
        return ResponseEntity.status(HttpStatus.OK).body(checkout.toResponse())
    }


}