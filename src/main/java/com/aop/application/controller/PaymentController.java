package com.aop.application.controller;

import com.aop.application.registry.PaymentServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * This is Service Locator factory bean example
 *
 */
@RestController
@RequestMapping("paymentservice")
public class PaymentController {



    @Autowired(required = true)
    private PaymentServiceRegistry paymentServiceRegistry;


    //this should be post

    @RequestMapping(value = {"/process"}, produces = {"application/json"},
            method = {RequestMethod.GET})
    public String process(@RequestParam("type") String type, @RequestParam("accountNumber") String accountNumber){
        return paymentServiceRegistry.getService(type).payment(accountNumber);
    }


}
