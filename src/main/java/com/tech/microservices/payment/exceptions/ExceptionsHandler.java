package com.tech.microservices.payment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 * @author Haytham DAHRI
 */
@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(value = {CustomerNotFoundException.class, PaymentNotFoundException.class})
    public ResponseEntity<ApiResponse> handleCustomerNotFoundExceptionsAndPaymentNotFoundExceptions(RuntimeException ex) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(HttpStatus.NOT_FOUND);
        apiResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        apiResponse.setTimestamp(LocalDateTime.now());
        apiResponse.setMessage(ex.getMessage());
        return ResponseEntity.ok(apiResponse);
    }

}
