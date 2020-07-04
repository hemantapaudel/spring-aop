package com.aop.application.registry;


import org.springframework.stereotype.Component;


@Component("internet")
public class InternetPaymentService implements PaymentService {
    @Override
    public String payment(String accountNumber) {
        System.out.println("Making payment using internet");
        return "Payment done using Internet payment ";
    }
}
