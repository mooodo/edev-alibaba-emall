package com.edev.emall.security.web;

import com.edev.emall.security.entity.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping(value = "login", produces = "application/json")
    public ResponseEntity<?> login(@RequestBody Credentials userAndPassword) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userAndPassword.getUsername(),
                        userAndPassword.getPassword()
                )
        );
        return ResponseEntity.ok(userAndPassword);
    }

    @RequestMapping(value = "/userinfo", produces = "application/json")
    public Map<String, Object> userinfo(UsernamePasswordAuthenticationToken token) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("user", token.getPrincipal());
        userInfo.put("authorities", AuthorityUtils.authorityListToSet(token.getAuthorities()));
        return userInfo;
    }
}
