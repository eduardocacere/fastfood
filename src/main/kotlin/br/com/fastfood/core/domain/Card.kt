package br.com.fastfood.core.domain

import br.com.fastfood.infra.enums.Brand

data class Card(
        val nameCard: String,
        val number: String,
        val dateValidate: String,
        val code: Number,
        val brand: Brand,
        val document: String
)
