package br.com.fastfood.core.repositoryService

import br.com.fastfood.core.domain.Client

interface ClientRepositoryService {

    fun create(client: Client): Client
    fun findByDoc(cpf: String): Client?
    fun findByEmail(cpf: String): Client?
    fun list(): MutableList<Client>
}