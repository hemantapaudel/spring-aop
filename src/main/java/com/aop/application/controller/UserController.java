package com.aop.application.controller;


import com.aop.application.model.User;
import com.aop.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userservice")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/get"}, produces = {"application/json"},
            method = {RequestMethod.GET})
    @ResponseBody
    public User getUser() {
       return userService.getUsers("user10",true);

    }

    @RequestMapping(value = {"/"}, produces = {"application/json"},
            method = {RequestMethod.GET})
    @ResponseBody
    public String healthcheck2() {
        return "OK";
    }
}
