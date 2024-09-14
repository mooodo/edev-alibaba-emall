package com.edev.emall.customer.service;

import com.edev.emall.customer.entity.JournalAccount;

import java.util.Collection;

public interface JournalAccountService {
    Long addJournalAccount(JournalAccount journalAccount);
    void removeJournalAccount(Long id);
    JournalAccount load(Long id);
    Collection<JournalAccount> getJournalAccount(Long accountId);
}
