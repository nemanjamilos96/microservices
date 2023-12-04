package com.microservices.customer.repository;

import com.microservices.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomRepository extends JpaRepository<Customer, Integer> {
}
