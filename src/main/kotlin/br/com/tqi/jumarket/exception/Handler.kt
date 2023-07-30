package br.com.tqi.jumarket.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException

@RestControllerAdvice
class Handler {

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(ex: IllegalArgumentException)
    : ResponseEntity<String> = ResponseEntity(ex.message, HttpStatus.BAD_REQUEST)

    @ExceptionHandler(IllegalStateException::class)
    fun handleIllegalStateException(ex: IllegalStateException)
    : ResponseEntity<String> = ResponseEntity(ex.message, HttpStatus.BAD_REQUEST)

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException)
    : ResponseEntity<String> = ResponseEntity(ex.message, HttpStatus.BAD_REQUEST)

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    fun handleMethodArgumentTypeMismatchException(ex: MethodArgumentTypeMismatchException)
    : ResponseEntity<String> = ResponseEntity(ex.message, HttpStatus.BAD_REQUEST)

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex: NotFoundException)
    : ResponseEntity<String> = ResponseEntity(ex.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(ex: BadRequestException)
    : ResponseEntity<String> = ResponseEntity(ex.message, HttpStatus.BAD_REQUEST)
}