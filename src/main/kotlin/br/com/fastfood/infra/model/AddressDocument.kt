package br.com.fastfood.infra.model

data class AddressDocument(

        val street: String,
        val number: String,
        val complement: String,
        val neighborhood: String,
        val city: String,
        val zipCode: Number

)
