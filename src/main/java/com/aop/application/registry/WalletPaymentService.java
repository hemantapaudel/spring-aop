package com.aop.application.registry;


import org.springframework.stereotype.Component;

@Component("wallet")
public class WalletPaymentService implements PaymentService {
    @Override
    public String payment(String accountNumber) {
        System.out.println("Making payment using wallet");
        return "Payment done using wallet payment ";
    }
}

