package br.com.fastfood.core.useCase.impl

import br.com.fastfood.core.domain.Client
import br.com.fastfood.core.domain.exception.NotFoundException
import br.com.fastfood.core.domain.request.ClientOrderRequest
import br.com.fastfood.core.extensions.toClient
import br.com.fastfood.core.port.repository.IClientRepository
import br.com.fastfood.core.useCase.IClientUseCase
import org.springframework.stereotype.Service

@Service
class ClientUseCase(
        private val repository: IClientRepository
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
                ?.takeIf { it.email.isNullOrEmpty().not() }
                ?.let { findByEmail(it.email!!) }
                ?: create(clientOrderRequest?.toClient()!!)

    }
}