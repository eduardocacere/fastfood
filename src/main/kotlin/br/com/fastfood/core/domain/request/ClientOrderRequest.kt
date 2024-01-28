package br.com.fastfood.core.domain.request

data class ClientOrderRequest(
        val name: String? = null,
        val email: String? = null,
        val cpf: String? = null
)
