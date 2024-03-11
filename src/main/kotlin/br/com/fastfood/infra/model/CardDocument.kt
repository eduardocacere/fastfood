package br.com.fastfood.infra.model

import br.com.fastfood.infra.enums.Brand

data class CardDocument(
        val nameCard: String,
        val number: String,
        val dateValidate: String,
        val code: Number,
        val brand: Brand,
        val document: String
)
