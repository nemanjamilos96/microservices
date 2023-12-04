package com.microservices.customer.service.impl;

import com.microservices.customer.model.CustomerRegistrationRequest;

public interface CustomerService {
    void registerCustomer(CustomerRegistrationRequest request);
}
