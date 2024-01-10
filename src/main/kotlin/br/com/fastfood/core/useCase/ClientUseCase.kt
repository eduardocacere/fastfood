package br.com.fastfood.core.useCase

import br.com.fastfood.core.domain.Client
import br.com.fastfood.core.port.repository.IClientRepository
import org.springframework.stereotype.Service

@Service
class ClientUseCase(
        private val repository: IClientRepository
): IClientUseCase {

    override fun findByDoc(cpf: String): Client {
        return repository.findByDoc(cpf)
                ?: throw Exception("Cliente não encontrado")
    }

    override fun create(client: Client): Client {
        return repository.create(client)
    }
}