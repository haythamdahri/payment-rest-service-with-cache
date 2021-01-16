package com.tech.microservices.payment.services;

import com.tech.microservices.payment.bo.CustomerBO;
import com.tech.microservices.payment.dto.CustomerRequestDTO;

/**
 * @author Haytham DAHRI
 */
public interface CustomerService {

    CustomerBO saveCustomer(Long id, CustomerRequestDTO customerRequest);

    CustomerBO getCustomer(Long id, String name);

    void deleteCustomer(Long id);

}
