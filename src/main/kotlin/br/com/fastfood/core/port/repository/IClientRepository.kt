package br.com.fastfood.core.port.repository

import br.com.fastfood.core.domain.Client

interface IClientRepository {

    fun create(client: Client): Client
    fun findByDoc(cpf: String): Client?
    fun list(): MutableList<Client>
}