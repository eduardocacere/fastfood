package br.com.fastfood.core.domain.exception

import org.springframework.http.HttpStatus

class FastFoodException(
        override val message: String?,
        val code: HttpStatus,
        override val cause: Throwable? = null
): Exception(message, cause)