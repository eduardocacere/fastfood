package br.com.fastfood.application.controller

import br.com.fastfood.application.gateway.WebhookGateway
import br.com.fastfood.core.domain.exception.Error
import br.com.fastfood.core.domain.response.OrderResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/webhook")
class WebhookController(
        private val webhookGateway: WebhookGateway
) {

    @Operation(summary = "Receive order payment confirmation")
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
    @PostMapping("/payment-confirm/{numberOrder}")
    fun paymentConfimed(@PathVariable numberOrder: String): ResponseEntity<Unit> {
        webhookGateway.paymentConfirmed(numberOrder)
        return ResponseEntity.status(HttpStatus.OK).build()
    }

    @Operation(summary = "Receive order payment confirmation")
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
    @PostMapping("/payment-refused/{numberOrder}")
    fun paymentRefused(@PathVariable numberOrder: String): ResponseEntity<Unit> {
        webhookGateway.paymentRefused(numberOrder)
        return ResponseEntity.status(HttpStatus.OK).build()
    }

}