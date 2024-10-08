package com.edev.emall.security.entity;

import com.edev.emall.authority.entity.Authority;
import com.edev.emall.authority.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultUserDetails implements UserDetails {
    private final User user;
    public DefaultUserDetails(User user) {
        this.user = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Authority> authorities = new ArrayList<>(user.getAuthorities());
        user.getRoles().forEach(role -> authorities.addAll(role.getAuthorities()));

        Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
        authorities.forEach(authority -> grantedAuthorities.add((GrantedAuthority) authority::getName));

        grantedAuthorities.add((GrantedAuthority) user::getUserType);
        return grantedAuthorities.stream().distinct().collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !user.getAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.getAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !user.getCredentialsExpired();
    }

    @Override
    public boolean isEnabled() {
        return !user.getDisabled();
    }
}
