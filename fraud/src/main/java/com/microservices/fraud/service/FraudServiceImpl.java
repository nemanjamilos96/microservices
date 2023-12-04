package com.microservices.fraud.service;

import com.microservices.fraud.model.FraudCheckHistory;
import com.microservices.fraud.repository.FraudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudServiceImpl implements  FraudService{

    @Autowired
    private FraudRepository fraudRepository;

    public boolean isFraudlentCustomer(Integer customerId){
        fraudRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
