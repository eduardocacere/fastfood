package br.com.fastfood.infra.extensions

import br.com.fastfood.infra.model.ClientDocument
import br.com.fastfood.core.domain.Client
import br.com.fastfood.core.domain.request.ClientOrderRequest
import br.com.fastfood.core.domain.request.ClientRequest
import br.com.fastfood.core.domain.response.ClientResponse

fun Client.toDocument(): ClientDocument =
        ClientDocument(
                id = id,
                name = name,
                email = email,
                cpf = cpf
        )

fun ClientDocument.toDomain(): Client =
        Client(
                id = id,
                name = name,
                email = email,
                cpf = cpf
        )

fun ClientRequest.toDomain(): Client =
        Client(
                name = name,
                email = email,
                cpf = cpf
        )

fun Client.toResponse(): ClientResponse =
        ClientResponse(
                name = name,
                email = email,
                cpf = cpf
        )

fun ClientOrderRequest.toClient(): Client =
        Client(
                name = name,
                email = email,
                cpf = cpf
        )
