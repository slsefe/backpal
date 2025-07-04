package org.example.buckpal.application.port.out;

import org.example.buckpal.domain.Account;

public interface UpdateAccountStatePort {
    void updateActivities(Account account);
}
