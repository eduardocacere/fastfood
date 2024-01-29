package br.com.fastfood.core.domain.exception

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.dao.IncorrectResultSizeDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionControllerAdvice {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler
    fun handleNotFoundException(ex: NotFoundException): ResponseEntity<Error> {

        val error = Error(
                message = ex.message.toString(),
                httpError = HttpStatus.NOT_FOUND.reasonPhrase,
                httpCode = HttpStatus.NOT_FOUND.value(),
        )

        logger.error("An error has occurred - ${ex.message}", ex.printStackTrace())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error)
    }

    @ExceptionHandler
    fun handleFastFoodException(ex: FastFoodException): ResponseEntity<Error> {

        val error = Error(
                message = ex.message.toString(),
                httpError = ex.code.reasonPhrase,
                httpCode = ex.code.value(),
        )

        logger.error("An error has occurred - ${ex.message}", ex.printStackTrace())
        return ResponseEntity.status(ex.code).body(error)
    }
    @ExceptionHandler
    fun handleHttpMessageNotReadableException(ex: HttpMessageNotReadableException): ResponseEntity<Error> {
        val error = Error(
                message = "Message Not Readable",
                httpError = HttpStatus.BAD_REQUEST.reasonPhrase,
                httpCode = HttpStatus.BAD_REQUEST.value()
        )

        logger.error("An error has occurred - ${ex.message}", ex.printStackTrace())
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error)
    }

    @ExceptionHandler
    fun handleIncorrectResultSizeDataAccessException(ex: IncorrectResultSizeDataAccessException): ResponseEntity<Error> {
        val error = Error(
                message = ex.message.toString(),
                httpError = HttpStatus.BAD_REQUEST.reasonPhrase,
                httpCode = HttpStatus.BAD_REQUEST.value()
        )

        logger.error("An error has occurred - ${ex.message}", ex.printStackTrace())
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error)
    }
    @ExceptionHandler
    fun hanfleNullPointerException(ex: NullPointerException): ResponseEntity<Error> {
        val error = Error(
                message = ex.message.toString(),
                httpError = HttpStatus.INTERNAL_SERVER_ERROR.reasonPhrase,
                httpCode = HttpStatus.INTERNAL_SERVER_ERROR.value()
        )

        logger.error("An error has occurred - ${ex.message}", ex.printStackTrace())
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error)
    }
}