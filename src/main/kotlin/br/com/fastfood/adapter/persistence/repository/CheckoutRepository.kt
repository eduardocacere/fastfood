package br.com.fastfood.adapter.persistence.repository

import br.com.fastfood.adapter.persistence.port.CheckoutMongoDNPort
import br.com.fastfood.core.domain.Checkout
import br.com.fastfood.core.extensions.toDocument
import br.com.fastfood.core.extensions.toDomain
import br.com.fastfood.core.port.repository.ICheckoutRepository
import org.springframework.stereotype.Repository

@Repository
class CheckoutRepository(
        private val checkoutMongoDNPort: CheckoutMongoDNPort
): ICheckoutRepository {


    override fun create(checkout: Checkout): Checkout {
        return checkoutMongoDNPort.save(checkout.toDocument()).toDomain()
    }

    override fun findByNumerCheckout(numberCheckout: String): Checkout? {
        return checkoutMongoDNPort.findByNumberCheckout(numberCheckout)?.toDomain()
    }

    override fun existNumbercheckout(numberOrder: String): Boolean {
        return checkoutMongoDNPort.existsByOrderNumberOrder(numberOrder)
    }
}