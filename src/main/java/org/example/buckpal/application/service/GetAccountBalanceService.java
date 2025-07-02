package org.example.buckpal.application.service;

import lombok.RequiredArgsConstructor;
import org.example.buckpal.application.port.in.GetAccountBalanceQuery;
import org.example.buckpal.application.port.out.LoadAccountPort;
import org.example.buckpal.domain.AccountId;
import org.example.buckpal.domain.Money;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class GetAccountBalanceService implements GetAccountBalanceQuery {

    private final LoadAccountPort loadAccountPort;

    @Override
    public Money getAccountBalance(AccountId accountId) {
        return loadAccountPort.loadAccount(accountId, LocalDateTime.now()).calculateBalance();
    }
}
