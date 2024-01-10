package br.com.fastfood.adapter.persistence.port

import br.com.fastfood.adapter.persistence.model.ClientDocument
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface ClientMongoDBPort: MongoRepository<ClientDocument, ObjectId> {

    fun findByCpf(cpf: String): ClientDocument?
}