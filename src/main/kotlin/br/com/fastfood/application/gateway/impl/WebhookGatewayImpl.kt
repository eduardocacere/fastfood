package br.com.fastfood.application.gateway.impl

import br.com.fastfood.application.gateway.WebhookGateway
import br.com.fastfood.core.useCase.IOrderUseCase
import br.com.fastfood.infra.enums.OrderStatus
import org.springframework.stereotype.Service

@Service
class WebhookGatewayImpl(
        private val useCaseOrder: IOrderUseCase
): WebhookGateway {

    override fun paymentConfirmed(numberOrder: String) {
        useCaseOrder.updateStatus(numberOrder, OrderStatus.PAYMENT_CONFIRMED)
        useCaseOrder.updateStatus(numberOrder, OrderStatus.IN_PREPARATION)
    }

    override fun paymentRefused(numberOrder: String) {
        useCaseOrder.updateStatus(numberOrder, OrderStatus.PAYMENT_REFUSED)
    }
}