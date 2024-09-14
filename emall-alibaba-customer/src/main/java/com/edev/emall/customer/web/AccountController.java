package com.edev.emall.customer.web;

import com.edev.emall.customer.entity.Account;
import com.edev.emall.customer.service.AccountService;
import com.edev.support.entity.ResultSet;
import com.edev.support.query.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping("topUp")
    public Double topUp(Long id, Double amount) {
        return accountService.topUp(id, amount);
    }
    @GetMapping("payoff")
    public Double payoff(Long id, Double amount) {
        return accountService.payoff(id, amount);
    }
    @GetMapping("refund")
    public Double refund(Long id, Double amount) {
        return accountService.refund(id, amount);
    }
    @GetMapping("get")
    public Account get(Long id) {
        return accountService.get(id);
    }
    @GetMapping("remove")
    public void remove(Long id) {
        accountService.remove(id);
    }
    @Autowired @Qualifier("accountQry")
    private QueryService queryService;
    @GetMapping("query")
    public ResultSet query(Map<String, Object> params) {
        return queryService.query(params);
    }
}
