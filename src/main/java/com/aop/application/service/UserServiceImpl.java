package com.aop.application.service;

import com.aop.application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDetailsService userDetailsService;


    /**
     * @Cacheable  is added to this method,  So that Spring will handle the caching. As a result of this annotation,
     * Spring will create a proxy of the UserServiceImpl to intercept calls to the getUsers method and call Ehcache.
     *
     * @param userName
     * @param isCacheable
     * @return
     */
    @Override
    @CacheEvict(
            value = "tenSecondCache",
            key = "'user-cache'+#userName",
            condition = "#isCacheable == null || isCacheable==false",
            beforeInvocation = true
    )
    @Cacheable(
            value = "tenSecondCache",
            key = "'user-cache'+#userName",
            condition = "#isCacheable != null && #isCacheable"
    )
    public User getUsers(String userName, boolean isCacheable) {

        //adding load
        sleep(10000);

        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);

        User user = new User();
        user.setUserName(userDetails.getUsername());
        user.setEnabled(userDetails.isEnabled());
        user.setAccountNonExpired(user.isCredentialsNonExpired());
        return user;
    }


    private void sleep(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
