package br.com.fastfood.core.useCase

import br.com.fastfood.core.domain.Client
import br.com.fastfood.core.domain.request.ClientOrderRequest

interface IClientUseCase {

    fun findByDoc(cpf: String): Client
    fun create(client: Client): Client
    fun findByEmail(email: String): Client?
    fun findOrCreate(clientOrderRequest: ClientOrderRequest?): Client

}