package br.com.fastfood.infra.repository

import br.com.fastfood.core.domain.Checkout
import br.com.fastfood.infra.extensions.toDocument
import br.com.fastfood.infra.extensions.toDomain
import br.com.fastfood.core.repositoryService.CheckoutRepositoryService
import br.com.fastfood.infra.port.CheckoutMongoDBPort
import org.springframework.stereotype.Repository

@Repository
class CheckoutRepository(
        private val checkoutMongoDBPort: CheckoutMongoDBPort
): CheckoutRepositoryService {


    override fun create(checkout: Checkout): Checkout {
        return checkoutMongoDBPort.save(checkout.toDocument()).toDomain()
    }

    override fun findByNumerCheckout(numberCheckout: String): Checkout? {
        return checkoutMongoDBPort.findByNumberCheckout(numberCheckout)?.toDomain()
    }

    override fun existNumbercheckout(number: String): Boolean {
        return checkoutMongoDBPort.existsByOrderNumberOrder(number)
    }
}