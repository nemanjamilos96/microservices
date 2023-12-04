package com.microservices.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("fraud")
@Component
public interface FraudClient {

    @GetMapping(path = "api/v1/fraud/check/{customerId}")
    FraudCheckRespons isFraudster(
            @PathVariable("customerId")Integer customerId);
}
