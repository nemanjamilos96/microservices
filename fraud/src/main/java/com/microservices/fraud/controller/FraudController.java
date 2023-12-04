package com.microservices.fraud.controller;

import com.microservices.fraud.service.FraudServiceImpl;
import com.microservices.clients.fraud.FraudCheckRespons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud/")
public class FraudController {

    @Autowired
    private FraudServiceImpl fraudService;

    @GetMapping(path = "check/{customerId}")
    public FraudCheckRespons isFraudster(@PathVariable("customerId")Integer customerId){
        boolean isFraudulentCustomer = fraudService.isFraudlentCustomer(customerId);
        return  new FraudCheckRespons(isFraudulentCustomer);
    }
}
