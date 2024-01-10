package br.com.fastfood.core.domain

import org.bson.types.ObjectId

data class Client(
        val id: ObjectId? = null,
        val name: String? = null,
        val email: String? = null,
        val cpf: String? = null
)
