package br.com.fastfood.core.domain.request

import br.com.fastfood.adapter.persistence.enums.Brand
import com.fasterxml.jackson.annotation.JsonFormat
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate
@Schema(
        description = "Model for a card credit."
)
data class CardRequest(
        @field:Schema(
                title = "Name of card holder",
                description = "Name of card holder",
                example = "Peter Parker",
                type = "String"
        )
        val nameCard: String,

        @field:Schema(
                title = "Credit Card Number",
                description = "Credit Card Number no punctuation",
                example = "1234567812345667",
                type = "String"
        )
        val number: String,

        @field:Schema(
                title = "Credit Card validate",
                description = "Credit Card validate",
                example = "MM-yyyy",
                type = "String",
                pattern = "MM-yyyy"

        )
        @JsonFormat(pattern="MM-yyyy")
        val dateValidate: LocalDate,

        @field:Schema(
                title = "Credit Card code",
                description = "Credit Card code",
                example = "123",
                type = "int",
                maxLength = 3
        )
        val code: Number,

        @field:Schema(
                title = "Credit Card brand",
                description = "Credit Card brand",
                type = "Brand"
        )
        val brand: Brand,

        @field:Schema(
                title = "Credit Card document" ,
                description = "Cpf of client - No punctuation ",
                example = "11122233344",
                type = "String"
        )
        val document: String
)
