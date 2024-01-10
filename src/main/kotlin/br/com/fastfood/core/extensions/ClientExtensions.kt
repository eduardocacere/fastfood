package br.com.fastfood.core.extensions

import br.com.fastfood.adapter.persistence.model.ClientDocument
import br.com.fastfood.core.domain.Client

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