package br.com.fastfood.adapter.persistence.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "client")
data class ClientDocument(

        @Id @Field(name = "_id")
        val id: ObjectId? = null,
        val name: String? = null,
        val email: String? = null,
        val cpf: String? = null
)
