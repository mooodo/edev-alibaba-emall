package com.edev.emall.oauth2.service;

import com.edev.emall.oauth2.entity.DefaultClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
public class DefaultClientDetailsService implements ClientDetailsService {
    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        UserDetails userDetails = userDetailsService.loadUserByUsername(clientId);
        return new DefaultClientDetails(userDetails);
    }
}
