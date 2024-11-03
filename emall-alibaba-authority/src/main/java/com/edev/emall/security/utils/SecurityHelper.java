package com.edev.emall.security.utils;

import com.edev.emall.authority.entity.User;
import com.edev.emall.authority.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class SecurityHelper {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
    public boolean passwordIsMatch(String source, String target) {
        return passwordEncoder.matches(source, target);
    }
    private Authentication getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication==null)
            throw new BadCredentialsException("No Authentication!");
        return authentication;
    }
    public String getMyName() {
        return getAuthentication().getName();
    }
    public String getPassword() {
        return getAuthentication().getCredentials().toString();
    }
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthentication().getAuthorities();
    }
    public User getCurrentUser() {
        String username = getAuthentication().getName();
        return userService.loadByName(username);
    }
}
