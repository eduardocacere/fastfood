package br.com.fastfood.infra.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "client")
data class ClientDocument(

        @Id @Field(name = "_id")
        val id: ObjectId? = null,
        val name: String? = null,
        @Indexed(unique = true)
        val email: String? = null,
        @Indexed(unique = true)
        val cpf: String? = null
)
