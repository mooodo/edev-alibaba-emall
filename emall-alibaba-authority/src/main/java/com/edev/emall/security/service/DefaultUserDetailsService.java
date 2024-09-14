package com.edev.emall.security.service;

import com.edev.emall.authority.entity.User;
import com.edev.emall.authority.service.UserService;
import com.edev.emall.security.entity.DefaultUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetails")
public class DefaultUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userService.loadByName(name);
        if(user==null) throw new UsernameNotFoundException(String.format("No found the user[%s]", name));
        return new DefaultUserDetails(user);
    }
}
