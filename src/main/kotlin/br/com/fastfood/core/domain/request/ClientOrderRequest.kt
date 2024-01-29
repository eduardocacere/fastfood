package br.com.fastfood.core.domain.request

import io.swagger.v3.oas.annotations.media.Schema

@Schema(
        description = "Model for a client."
)
data class ClientOrderRequest(
        @field:Schema(
                title = "Name of client",
                description = "Name of client",
                example = "Peter Parker",
                type = "String"
        )
        val name: String? = null,

        @field:Schema(
                title = "Email of client",
                description = "Email of client",
                example = "teste@teste.com",
                type = "String"
        )
        val email: String? = null,

        @field:Schema(
                title = "Cpf of client" ,
                description = "No punctuation ",
                example = "11122233344",
                type = "String"
        )
        val cpf: String? = null
)
