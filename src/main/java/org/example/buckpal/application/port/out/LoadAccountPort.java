package org.example.buckpal.application.port.out;

import org.example.buckpal.domain.Account;

public interface LoadAccountPort {
    Account loadAccount(Long accountId);
}
