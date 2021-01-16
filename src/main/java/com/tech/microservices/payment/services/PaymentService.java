package com.tech.microservices.payment.services;

import com.tech.microservices.payment.bo.PaymentBO;
import com.tech.microservices.payment.dto.PaymentRequestDTO;

/**
 * @author Haytham DAHRI
 */
public interface PaymentService {

    PaymentBO savePayment(Long id, PaymentRequestDTO paymentRequest);

    PaymentBO getPayment(Long id);

    void deletePayment(Long id);

}
