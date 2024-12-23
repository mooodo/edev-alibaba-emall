package com.edev.emall.customer.service.impl;

import com.edev.emall.customer.entity.Account;
import com.edev.emall.customer.entity.JournalAccount;
import com.edev.emall.customer.service.AccountService;
import com.edev.emall.customer.service.CustomerService;
import com.edev.emall.customer.service.JournalAccountService;
import com.edev.emall.utils.ValidUtils;
import com.edev.support.dao.BasicDao;
import com.edev.support.exception.ValidException;
import com.edev.support.utils.DateUtils;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class AccountServiceImpl implements AccountService {
    private final BasicDao dao;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private JournalAccountService journalAccountService;
    public AccountServiceImpl(BasicDao dao) {
        this.dao = dao;
    }

    private void validAccount(Account account) {
        ValidUtils.isNotExists(account.getId(), id->customerService.exists(id), "the account of customer");
    }

    @Override
    public Long create(@NonNull Account account) {
        validAccount(account);
        account.setCreateTime(DateUtils.getNow());
        return dao.insert(account);
    }

    @Override
    public void modify(@NonNull Account account) {
        validAccount(account);
        account.setModifyTime(DateUtils.getNow());
        dao.update(account);
    }

    @Override
    public void remove(@NonNull Long id) {
        dao.delete(id, Account.class);
    }

    @Override
    public Account get(@NonNull Long id) {
        return dao.load(id, Account.class);
    }
    @Override
    @Transactional
    public Double topUp(@NonNull Long id, @NonNull Double amount) {
        Double balance;
        Account account = this.get(id);
        if(account==null) {
            account = new Account();
            account.setId(id);
            account.setBalance(amount);
            create(account);
            balance = amount;
        } else {
            balance = account.getBalance() + amount;
            account.setBalance(balance);
            modify(account);
        }

        JournalAccount journalAccount =
                new JournalAccount(account.getId(), amount, "topUp");
        journalAccountService.addJournalAccount(journalAccount);
        return balance;
    }

    @Override
    @Transactional
    public Double payoff(@NonNull Long id, @NonNull Double amount) {
        Account account = this.get(id);
        if(account==null)
            throw new ValidException("The account[id:%d] isn't available", id);
        if(account.getBalance() < amount)
            throw new ValidException("The account[id:%d] has no enough money[%d]", id, account.getBalance());
        Double balance = account.getBalance() - amount;
        account.setBalance(balance);
        this.modify(account);

        JournalAccount journalAccount =
                new JournalAccount(account.getId(), amount, "payoff");
        journalAccountService.addJournalAccount(journalAccount);
        return balance;
    }

    @Override
    @Transactional
    public Double refund(@NonNull Long id, @NonNull Double amount) {
        Account account = this.get(id);
        if(account==null)
            throw new ValidException("The account[id:%d] isn't available", id);
        Double balance = account.getBalance() + amount;
        account.setBalance(balance);
        this.modify(account);

        JournalAccount journalAccount =
                new JournalAccount(account.getId(), amount, "refund");
        journalAccountService.addJournalAccount(journalAccount);
        return balance;
    }
}
