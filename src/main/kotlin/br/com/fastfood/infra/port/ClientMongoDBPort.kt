package br.com.fastfood.infra.port

import br.com.fastfood.infra.model.ClientDocument
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface ClientMongoDBPort: MongoRepository<ClientDocument, ObjectId> {

    fun findByCpf(cpf: String): ClientDocument?

    fun findByEmail(email: String): ClientDocument?
}