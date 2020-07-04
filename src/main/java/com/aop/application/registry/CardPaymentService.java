package com.aop.application.registry;

import org.springframework.stereotype.Component;

@Component("card")
public class CardPaymentService implements PaymentService {
    @Override
    public String payment(String accountNumber) {
        System.out.println("Making payment using card");
        return "Payment done using Card paymnet ";
    }
}
