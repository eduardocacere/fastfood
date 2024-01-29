package br.com.fastfood.adapter.web

import br.com.fastfood.core.domain.exception.Error
import br.com.fastfood.core.domain.request.CheckoutRequest
import br.com.fastfood.core.domain.request.OrderStoreRequest
import br.com.fastfood.core.domain.response.CheckoutResponse
import br.com.fastfood.core.extensions.toResponse
import br.com.fastfood.core.useCase.IUseCaseCheckout
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
@RequestMapping("/checkout")
class CheckoutController(
    private val useCase: IUseCaseCheckout
) {

    @Operation(summary = "Send order for checkout")
    @ApiResponses(value = [
        ApiResponse(
                responseCode = "200",
                description = "Create client",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = CheckoutResponse::class))]
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
    fun checkout(@RequestBody checkoutRequest: CheckoutRequest): ResponseEntity<CheckoutResponse> {
        val checkout = useCase.checkout(checkoutRequest)
        return ResponseEntity.status(HttpStatus.MULTI_STATUS).body(checkout.toResponse())

    }

    @Operation(summary = "Find checkout by numberCheckout")
    @ApiResponses(value = [
        ApiResponse(
                responseCode = "200",
                description = "Create client",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = CheckoutResponse::class))]
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
    @GetMapping("/numberCheckout/{numberCheckout}")
    fun findByNumberCheckout(@PathVariable numberCheckout: String): ResponseEntity<CheckoutResponse> {
        val checkout = useCase.findByNumberCheckout(numberCheckout)
        return ResponseEntity.status(HttpStatus.OK).body(checkout.toResponse())
    }


}