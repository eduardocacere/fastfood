package br.com.fastfood.adapter.persistence.model

import br.com.fastfood.adapter.persistence.enums.Brand
import java.time.LocalDate

data class CardDocument(
        val nameCard: String,
        val number: String,
        val dateValidate: LocalDate,
        val code: Number,
        val brand: Brand,
        val document: String
)
