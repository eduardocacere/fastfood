package br.com.fastfood.core.useCase

import br.com.fastfood.core.domain.Client

interface IClientUseCase {

    fun findByDoc(cpf: String): Client
    fun create(client: Client): Client

}