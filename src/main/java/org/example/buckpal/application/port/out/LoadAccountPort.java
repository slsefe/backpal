package org.example.buckpal.application.port.out;

import org.example.buckpal.domain.Account;
import org.example.buckpal.domain.AccountId;

import java.time.LocalDateTime;

public interface LoadAccountPort {
    Account loadAccount(AccountId accountId, LocalDateTime now);
}
