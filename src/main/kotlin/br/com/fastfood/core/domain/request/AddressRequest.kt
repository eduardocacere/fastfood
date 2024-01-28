package br.com.fastfood.core.domain.request

data class AddressRequest(
        val street: String,
        val number: String,
        val complement: String,
        val neighborhood: String,
        val city: String,
        val zipCode: Number
)
