package br.com.fastfood.adapter.web

import br.com.fastfood.core.domain.Client
import br.com.fastfood.core.domain.exception.Error
import br.com.fastfood.core.domain.request.ClientRequest
import br.com.fastfood.core.domain.response.ClientResponse
import br.com.fastfood.core.extensions.toDomain
import br.com.fastfood.core.extensions.toResponse
import br.com.fastfood.core.useCase.IClientUseCase
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
@RequestMapping("/client")
class ClientController(
        private val useCase: IClientUseCase
) {

    @Operation(summary = "Create a new client")
    @ApiResponses(value = [
        ApiResponse(
                responseCode = "200",
                description = "Create client",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = ClientResponse::class))]
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
    fun create(@RequestBody client: ClientRequest): ResponseEntity<ClientResponse> {
        val clientResponse = useCase.create(client.toDomain())
        return ResponseEntity.status(HttpStatus.OK).body(clientResponse.toResponse())
    }

    @Operation(summary = "Find client by doc")
    @ApiResponses(value = [
        ApiResponse(
                responseCode = "200",
                description = "Create client",
                content = [Content(mediaType = "application/json", schema = Schema(implementation = ClientResponse::class))]
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
    @GetMapping("/{doc}")
    fun findByDoc(@PathVariable doc: String): ResponseEntity<ClientResponse> {
        val client = useCase.findByDoc(doc)
        return ResponseEntity.status(HttpStatus.OK).body(client.toResponse())
    }


}