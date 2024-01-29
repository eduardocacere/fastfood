package br.com.fastfood.core.domain

import br.com.fastfood.adapter.persistence.enums.Brand
import java.time.LocalDate

data class Card(
        val nameCard: String,
        val number: String,
        val dateValidate: String,
        val code: Number,
        val brand: Brand,
        val document: String
)
