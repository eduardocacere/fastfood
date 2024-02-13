package br.com.fastfood.core.useCase.impl

import br.com.fastfood.core.domain.Client
import br.com.fastfood.core.domain.exception.NotFoundException
import br.com.fastfood.core.domain.request.ClientOrderRequest
import br.com.fastfood.infra.extensions.toClient
import br.com.fastfood.core.repositoryService.ClientRepositoryService
import br.com.fastfood.core.useCase.IClientUseCase
import org.springframework.stereotype.Service

@Service
class ClientUseCase(
        private val repository: ClientRepositoryService
): IClientUseCase {

    override fun findByDoc(cpf: String): Client {
        return repository.findByDoc(cpf)
                ?: throw NotFoundException("Client not Found")
    }

    override fun create(client: Client): Client {
        return repository.create(client)
    }

    override fun findByEmail(email: String): Client? {
        return repository.findByEmail(email)
    }

    override fun findOrCreate(clientOrderRequest: ClientOrderRequest?): Client {
        return clientOrderRequest
                ?.let { findByEmail(it.email!!) }
                ?: create(clientOrderRequest?.toClient()!!)

    }
}