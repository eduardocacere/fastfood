package br.com.fastfood.core.domain

data class Address (

        val street: String,
        val number: String,
        val complement: String,
        val neighborhood: String,
        val city: String,
        val zipCode: Number
)