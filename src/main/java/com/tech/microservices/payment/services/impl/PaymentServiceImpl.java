package com.tech.microservices.payment.services.impl;

import com.tech.microservices.payment.bo.PaymentBO;
import com.tech.microservices.payment.dao.CustomerRepository;
import com.tech.microservices.payment.dao.PaymentRepository;
import com.tech.microservices.payment.dto.PaymentRequestDTO;
import com.tech.microservices.payment.exceptions.PaymentNotFoundException;
import com.tech.microservices.payment.services.PaymentService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;

/**
 * @author Haytham DAHRI
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final CustomerRepository customerRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository, CustomerRepository customerRepository) {
        this.paymentRepository = paymentRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public PaymentBO savePayment(Long id, PaymentRequestDTO paymentRequest) {
        PaymentBO payment;
        if (id != null) {
            payment = this.paymentRepository.findById(id).orElseThrow(PaymentNotFoundException::new);
        } else {
            payment = new PaymentBO();
        }
        payment.setAmount(paymentRequest.getAmount());
        payment.setCustomer(this.customerRepository.findById(paymentRequest.getCustomer()).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND)));
        payment.setPaymentDate(LocalDateTime.now());
        return this.paymentRepository.save(payment);
    }

    @Override
    @Cacheable(value = "paymentCache")
    public PaymentBO getPayment(Long id) {
        return this.paymentRepository.findById(id).orElseThrow(PaymentNotFoundException::new);
    }

    @Override
    public void deletePayment(Long id) {
        this.paymentRepository.deleteById(id);
    }
}
