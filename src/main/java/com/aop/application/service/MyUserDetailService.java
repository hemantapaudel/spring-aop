package com.aop.application.service;


import com.aop.application.model.MyUserDetails;
import com.aop.application.model.User;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class MyUserDetailService implements UserDetailsService {


    List<User> userList  = new ArrayList<>();


    @Autowired
    public MyUserDetailService() {


        for (int i = 10; i < 100; i++) {

            User user = new User(0,
                    "user" + i,
                    "password" + i,
                    "ROLE_USER",
                    true,
                    true,
                    true,
                    true
            );
            userList.add(user);
        }
        for (int i = 110; i < 200; i++) {

            User user = new User(0,
                    "user" + i,
                    "password" + i,
                    "ROLE_USER,ROLE_ADMIN",
                    true,
                    true,
                    true,
                    true
            );
            userList.add(user);

        }

    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> optionalUser = userList.stream()
                .filter(user -> user.getUserName().equals(userName))
                .findAny();
        System.out.println(optionalUser.isPresent());
        System.out.println(optionalUser.get().getUserName() + " "+  optionalUser.get().getRoles());
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("No user details found:" + userName));

       return optionalUser.map(MyUserDetails::new).get();
    }




}
