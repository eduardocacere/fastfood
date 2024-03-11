package br.com.fastfood.infra.extensions

import br.com.fastfood.infra.model.CardDocument
import br.com.fastfood.infra.model.CheckoutDocument
import br.com.fastfood.core.domain.Card
import br.com.fastfood.core.domain.Checkout
import br.com.fastfood.core.domain.request.CardRequest
import br.com.fastfood.core.domain.response.CheckoutResponse


fun CheckoutDocument.toDomain(): Checkout =
        Checkout(
                id = id,
                order = order.toDomain(),
                numberCheckout = numberCheckout,
                typePayment = typePayment,
                card = card.toDomain(),
                value = value,
                status = status,
                createAt = createAt

        )

fun Checkout.toDocument(): CheckoutDocument =
        CheckoutDocument(
                id = id,
                order = order.toDocument(),
                numberCheckout = numberCheckout,
                typePayment = typePayment,
                card = card.toDocument(),
                value = value,
                status = status,
                createAt = createAt
        )

fun CardDocument.toDomain(): Card =
        Card(
                nameCard = nameCard,
                number = number,
                dateValidate = dateValidate,
                code = code,
                brand = brand,
                document = document
        )

fun Card.toDocument(): CardDocument =
        CardDocument(
                nameCard = nameCard,
                number = number,
                dateValidate = dateValidate,
                code = code,
                brand = brand,
                document = document
        )

fun CardRequest.toCardDomain(): Card =
        Card(
                nameCard = nameCard,
                number = number,
                dateValidate = dateValidate,
                code = code,
                brand = brand,
                document = document
        )

fun Checkout.toResponse(): CheckoutResponse =
        CheckoutResponse(
                numberCheckout = numberCheckout,
                status = status
        )
