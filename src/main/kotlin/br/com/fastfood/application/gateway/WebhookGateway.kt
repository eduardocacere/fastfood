package br.com.fastfood.application.gateway

interface WebhookGateway {

    fun paymentConfirmed(numberOrder: String)

    fun paymentRefused(numberOrder: String)

}