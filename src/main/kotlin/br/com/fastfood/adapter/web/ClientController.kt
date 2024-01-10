package br.com.fastfood.adapter.web

import br.com.fastfood.core.domain.Client
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
    fun create(client: Client): ResponseEntity<Client> {
        val clientResponse = useCase.create(client)
        return ResponseEntity.status(HttpStatus.OK).body(clientResponse)
    }

    @GetMapping("/{doc}")
    fun findByDoc(@PathVariable doc: String): ResponseEntity<Client> {
        val client = useCase.findByDoc(doc)
        return ResponseEntity.status(HttpStatus.OK).body(client)
    }


}