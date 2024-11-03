package com.edev.emall.oauth2.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DefaultClientDetails implements ClientDetails {
    private final UserDetails userDetails;
    public DefaultClientDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
    @Override
    public String getClientId() {
        return userDetails.getUsername();
    }

    @Override
    public Set<String> getResourceIds() {
        return null;
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {
        return userDetails.getPassword();
    }

    @Override
    public boolean isScoped() {
        return false;
    }

    @Override
    public Set<String> getScope() {
        return null;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        Set<String> authorizedGrantTypes = new HashSet<>();
        authorizedGrantTypes.add("password");
        return authorizedGrantTypes;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return (Collection<GrantedAuthority>) userDetails.getAuthorities();
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return 40775;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return 40775*3;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
