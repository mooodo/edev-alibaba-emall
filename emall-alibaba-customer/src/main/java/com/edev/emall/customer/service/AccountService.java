package com.edev.emall.customer.service;


import com.edev.emall.customer.entity.Account;

public interface AccountService {
    Long create(Account account);
    void modify(Account account);
    void remove(Long id);
    Account get(Long id);
    Double topUp(Long id, Double amount);
    Double payoff(Long id, Double amount);
    Double refund(Long id, Double amount);
}
