package br.com.fastfood.core.domain.response

data class OrderQueueResponse(

        var done: MutableList<OrderResponse>? = null,
        var inPreparation: MutableList<OrderResponse>? = null,
        var receveid: MutableList<OrderResponse>? = null,

        )
