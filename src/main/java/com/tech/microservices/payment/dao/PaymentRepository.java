package com.tech.microservices.payment.dao;

import com.tech.microservices.payment.bo.PaymentBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Haytham DAHRI
 */
@Repository
public interface PaymentRepository extends JpaRepository<PaymentBO, Long> {
}
