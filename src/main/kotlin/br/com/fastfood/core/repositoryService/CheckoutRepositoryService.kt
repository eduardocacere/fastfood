package br.com.fastfood.core.repositoryService

import br.com.fastfood.core.domain.Checkout

interface CheckoutRepositoryService {

    fun create(checkout: Checkout): Checkout

    fun findByNumerCheckout(numberCheckout: String): Checkout?

    fun existNumbercheckout(numberCheckout: String): Boolean

}