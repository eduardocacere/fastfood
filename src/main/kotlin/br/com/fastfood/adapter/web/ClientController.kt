package br.com.fastfood.adapter.web

import br.com.fastfood.core.domain.Client
import br.com.fastfood.core.domain.request.ClientRequest
import br.com.fastfood.core.domain.response.ClientResponse
import br.com.fastfood.core.extensions.toDomain
import br.com.fastfood.core.extensions.toResponse
import br.com.fastfood.core.useCase.IClientUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/client")
class ClientController(
        private val useCase: IClientUseCase
) {

    @PostMapping
    fun create(client: ClientRequest): ResponseEntity<ClientResponse> {
        val clientResponse = useCase.create(client.toDomain())
        return ResponseEntity.status(HttpStatus.OK).body(clientResponse.toResponse())
    }

    @GetMapping("/{doc}")
    fun findByDoc(@PathVariable doc: String): ResponseEntity<ClientResponse> {
        val client = useCase.findByDoc(doc)
        return ResponseEntity.status(HttpStatus.OK).body(client.toResponse())
    }


}