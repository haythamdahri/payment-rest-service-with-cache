package com.tech.microservices.payment.dao;

import com.tech.microservices.payment.bo.CustomerBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Haytham DAHRI
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerBO, Long> {
}
