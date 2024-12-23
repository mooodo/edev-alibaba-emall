package com.edev.emall.customer.entity;

import com.edev.support.entity.Entity;
import com.edev.support.utils.DateUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class JournalAccount extends Entity<Long> {
    private Long id;
    private Long accountId;
    private Double amount;
    private String operation;
    private Date operateTime;

    public JournalAccount() {}

    public JournalAccount(Long accountId, Double amount, String operation) {
        this(null, accountId, amount, operation, null);
    }

    public JournalAccount(Long id, Long accountId, Double amount, String operation, Date operateTime) {
        setId(id);
        setAccountId(accountId);
        setAmount(amount);
        setOperation(operation);
        setOperateTime(operateTime);
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime==null ? DateUtils.getNow() : operateTime;
    }
}
