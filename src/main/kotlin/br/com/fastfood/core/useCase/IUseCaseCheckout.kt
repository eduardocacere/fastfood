package br.com.fastfood.core.useCase

import br.com.fastfood.core.domain.Checkout
import br.com.fastfood.core.domain.request.CheckoutRequest

interface IUseCaseCheckout {

    fun checkout(checkoutRequest: CheckoutRequest): Checkout

    fun findByNumberCheckout(numberCheckout: String): Checkout
}