package br.com.fastfood.core.domain.request


data class ClientRequest(
        val name: String? = null,
        val email: String? = null,
        val cpf: String? = null
)
