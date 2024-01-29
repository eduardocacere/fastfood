package br.com.fastfood.core.domain.exception

class NotFoundException(
        override val message: String?,
        override val cause: Throwable? = null
): Exception(message, cause) {

}