package com.tech.microservices.payment.services.impl;

import com.tech.microservices.payment.bo.CustomerBO;
import com.tech.microservices.payment.dao.CustomerRepository;
import com.tech.microservices.payment.dto.CustomerRequestDTO;
import com.tech.microservices.payment.exceptions.CustomerNotFoundException;
import com.tech.microservices.payment.services.CustomerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author Haytham DAHRI
 */
@Service
@Log4j2
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerBO saveCustomer(Long id, CustomerRequestDTO customerRequest) {
        CustomerBO customer;
        if (id != null) {
            customer = this.customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
        } else {
            customer = new CustomerBO();
        }
        customer.setBirthDate(customerRequest.getBirthDate());
        customer.setGivenName(customerRequest.getGivenName());
        customer.setFamilyName(customerRequest.getFamilyName());
        log.info("CustomerBO: {}", customer);
        return this.customerRepository.save(customer);
    }

    @Override
    @Cacheable(value = "customerCache", key = "T(java.util.Objects).hash(#id, #name)")
    public CustomerBO getCustomer(Long id, String name) {
        return this.customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }

    @Override
    public void deleteCustomer(Long id) {
        this.customerRepository.deleteById(id);
    }
}
