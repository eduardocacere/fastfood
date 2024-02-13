package br.com.fastfood.core.useCase.impl

import br.com.fastfood.infra.enums.OrderStatus
import br.com.fastfood.infra.enums.TypePayment
import br.com.fastfood.infra.repository.CheckoutRepository
import br.com.fastfood.core.domain.Checkout
import br.com.fastfood.core.domain.exception.FastFoodException
import br.com.fastfood.core.domain.exception.NotFoundException
import br.com.fastfood.core.domain.request.CheckoutRequest
import br.com.fastfood.infra.extensions.toCardDomain
import br.com.fastfood.core.useCase.IOrderUseCase
import br.com.fastfood.core.useCase.IUseCaseCheckout
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import java.time.LocalDateTime.now
import java.util.UUID

@Service
class UseCaseCheckout(
        private val checkoutRepository: CheckoutRepository,
        private val useCaseOrder: IOrderUseCase
): IUseCaseCheckout {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun checkout(checkoutRequest: CheckoutRequest): Checkout {
        logger.info("Starting checkout $checkoutRequest")

        val isExist = checkoutRepository.existNumbercheckout(checkoutRequest.numberOrder)
        if (isExist) {
            throw FastFoodException(message = "There is already a payment in progress for this order", code = HttpStatus.BAD_REQUEST)
        }
        val order = useCaseOrder.findByNumberOrder(checkoutRequest.numberOrder)

        if(order.total.equals(checkoutRequest.value).not()) {
            throw FastFoodException(message = "Payment must be made in full", code = HttpStatus.BAD_REQUEST)
        }

        val card = checkoutRequest.card.toCardDomain()

        val checkout = Checkout(
                order = order,
                numberCheckout = UUID.randomUUID().toString(),
                typePayment = TypePayment.CREDIT,
                card = card,
                value = checkoutRequest.value,
                status = OrderStatus.AWAITING_PAYMENT,
                createAt = now()
        )

        val checkoutCreated = checkoutRepository.create(checkout)

        order.status = OrderStatus.AWAITING_PAYMENT
        useCaseOrder.update(order)

        return checkoutCreated

    }

    override fun findByNumberCheckout(numberCheckout: String): Checkout {
        return checkoutRepository.findByNumerCheckout(numberCheckout)
                ?: throw NotFoundException("Checkout not found")
    }
}