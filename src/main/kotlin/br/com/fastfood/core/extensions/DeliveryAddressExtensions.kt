package br.com.fastfood.core.extensions

import br.com.fastfood.adapter.persistence.model.AddressDocument
import br.com.fastfood.core.domain.Address

fun Address.toDocument(): AddressDocument =
        AddressDocument(
                street = street,
                number = number,
                complement = complement,
                neighborhood = neighborhood,
                city = city,
                zipCode = zipCode
        )

fun AddressDocument.toDomain(): Address =
        Address(
                street = street,
                number = number,
                complement = complement,
                neighborhood = neighborhood,
                city = city,
                zipCode = zipCode
        )