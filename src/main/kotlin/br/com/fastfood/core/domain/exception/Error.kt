package br.com.fastfood.core.domain.exception

data class Error(
        val message: String,
        val httpCode: Int,
        val httpError: String
)
