package br.com.fastfood.adapter.persistence.repository

import br.com.fastfood.adapter.persistence.port.ClientMongoDBPort
import br.com.fastfood.core.domain.Client
import br.com.fastfood.core.extensions.toDocument
import br.com.fastfood.core.extensions.toDomain
import br.com.fastfood.core.port.repository.IClientRepository
import org.springframework.stereotype.Repository

@Repository
class ClientRepository(
        private val clientMongoDBPort: ClientMongoDBPort
): IClientRepository {

    override fun create(client: Client): Client {
        return clientMongoDBPort.save(client.toDocument()).toDomain()
    }

    override fun findByDoc(cpf: String): Client? {
        return clientMongoDBPort.findByCpf(cpf)
                ?.toDomain()
    }

    override fun findByEmail(email: String): Client? {
        return clientMongoDBPort.findByEmail(email)
                ?.toDomain()
    }

    override fun list(): MutableList<Client> {
        return clientMongoDBPort.findAll()
                .map { it.toDomain() }
                .toMutableList()
    }
}