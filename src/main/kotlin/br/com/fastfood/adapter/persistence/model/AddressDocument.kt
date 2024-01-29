package br.com.fastfood.adapter.persistence.model

data class AddressDocument(

        val street: String,
        val number: String,
        val complement: String,
        val neighborhood: String,
        val city: String,
        val zipCode: Number

)
