package br.com.fastfood.core.port.repository

import br.com.fastfood.core.domain.Checkout

interface ICheckoutRepository {

    fun create(checkout: Checkout): Checkout

    fun findByNumerCheckout(numberCheckout: String): Checkout?

    fun existNumbercheckout(numberCheckout: String): Boolean

}