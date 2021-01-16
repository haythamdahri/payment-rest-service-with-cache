package com.tech.microservices.payment.controllers;

import com.tech.microservices.payment.bo.PaymentBO;
import com.tech.microservices.payment.dto.PaymentRequestDTO;
import com.tech.microservices.payment.services.PaymentService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Haytham DAHRI
 */
@RestController
@RequestMapping(path = "/api/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(path = "/")
    public ResponseEntity<PaymentBO> savePayment(@RequestHeader HttpHeaders httpHeaders,
                                                 @RequestBody PaymentRequestDTO paymentRequest) {
        return ResponseEntity.ok(this.paymentService.savePayment(null, paymentRequest));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PaymentBO> savePayment(@RequestHeader HttpHeaders httpHeaders,
                                                 @PathVariable(name = "id") Long id,
                                                 @RequestBody PaymentRequestDTO paymentRequest) {
        return ResponseEntity.ok(this.paymentService.savePayment(id, paymentRequest));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PaymentBO> getPayment(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(this.paymentService.getPayment(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable(name = "id") Long id) {
        this.paymentService.deletePayment(id);
        return ResponseEntity.ok().build();
    }

}
