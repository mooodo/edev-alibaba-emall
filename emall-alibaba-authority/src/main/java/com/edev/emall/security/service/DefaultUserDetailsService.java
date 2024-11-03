package com.edev.emall.security.service;

import com.edev.emall.authority.entity.Authority;
import com.edev.emall.authority.entity.Role;
import com.edev.emall.authority.entity.User;
import com.edev.emall.authority.service.RoleService;
import com.edev.emall.authority.service.UserService;
import com.edev.emall.security.entity.DefaultUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service()
public class DefaultUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Override
    public UserDetails loadUserByUsername(String name) {
        User user = userService.loadByName(name);
        if(user==null) throw new UsernameNotFoundException(String.format("No found the user[%s]", name));
        loadAuthoritiesForEachRole(user);
        return new DefaultUserDetails(user);
    }

    private void loadAuthoritiesForEachRole(User user) {
        List<Long> roleIds = new ArrayList<>();
        user.getRoles().forEach(role->roleIds.add(role.getId()));
        Collection<Role> roles = roleService.loadAll(roleIds);
        Map<Long, Collection<Authority>> map = new HashMap<>();
        roles.forEach(role -> map.put(role.getId(), role.getAuthorities()));
        user.getRoles().forEach(role -> role.setAuthorities(map.get(role.getId())));
    }
}
