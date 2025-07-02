package org.example.buckpal.application.port.in;

import org.example.buckpal.domain.AccountId;
import org.example.buckpal.domain.Money;

public interface GetAccountBalanceQuery {

    public Money getAccountBalance(AccountId accountId);
}
