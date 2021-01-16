package com.tech.microservices.payment.controllers;

import com.tech.microservices.payment.bo.CustomerBO;
import com.tech.microservices.payment.dto.CustomerRequestDTO;
import com.tech.microservices.payment.services.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Haytham DAHRI
 */
@RestController
@RequestMapping(path = "/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(path = "/")
    public ResponseEntity<CustomerBO> saveCustomer(@RequestHeader HttpHeaders httpHeaders,
                                                   @RequestBody CustomerRequestDTO customerRequest) {
        return ResponseEntity.ok(this.customerService.saveCustomer(null, customerRequest));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CustomerBO> updateCustomer(@RequestHeader HttpHeaders httpHeaders,
                                                     @PathVariable(name = "id") Long id,
                                                     @RequestBody CustomerRequestDTO customerRequest) {
        return ResponseEntity.ok(this.customerService.saveCustomer(id, customerRequest));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CustomerBO> getCustomer(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(this.customerService.getCustomer(id, "Haytham"));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable(name = "id") Long id) {
        this.customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }

}
