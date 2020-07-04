package com.aop.application.registry;

public interface PaymentServiceRegistry {
    PaymentService getService(String serviceName);
}
