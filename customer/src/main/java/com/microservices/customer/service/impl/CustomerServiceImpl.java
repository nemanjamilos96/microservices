package com.microservices.customer.service.impl;

import com.microservices.customer.repository.CustomRepository;
import com.microservices.customer.model.Customer;
import com.microservices.customer.model.CustomerRegistrationRequest;
import com.microservices.clients.fraud.FraudCheckRespons;
import com.microservices.clients.fraud.FraudClient;
import com.microservices.clients.notification.NotificationClient;
import com.microservices.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomRepository customRepository;
    @Autowired
    private FraudClient fraudClient;
    @Autowired
    private NotificationClient notificationClient;

    @Override
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        //todo: check if email valid
        //todo: check if email not taken
        customRepository.saveAndFlush(customer);
        System.out.println(customer.getId());
        //todo: check if fraudster
        FraudCheckRespons respons = fraudClient.isFraudster(customer.getId());
        if(respons.getIsFraudster())
            throw new IllegalStateException("Is fraudster");
        notificationClient.sendNotification(new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to Microservices...",
                        customer.getFirstName())
        ));
    }
}
