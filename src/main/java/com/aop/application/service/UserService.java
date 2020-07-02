package com.aop.application.service;

import com.aop.application.model.User;


public interface UserService {

   User getUsers(String userName,boolean isCacheable);
}
