package com.edev.emall.security.utils;

import com.edev.emall.security.service.DefaultPasswordEncoder;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtils {
    private static final PasswordEncoder passwordEncoder = DefaultPasswordEncoder.build();
    public static boolean passwordIsMatch(String source, String target) {
        return passwordEncoder.matches(source, target);
    }
    public static String getMyName() {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        if(currentUser==null)
            throw new BadCredentialsException("No Authentication for the current user!");
        return currentUser.getName();
    }
}
