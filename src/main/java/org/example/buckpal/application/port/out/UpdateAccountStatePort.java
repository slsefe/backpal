package org.example.buckpal.application.port.out;

import org.example.buckpal.domain.Account;

public interface UpdateAccountStatePort {
    /**
     * save activity for account
     */
    void updateActivities(Account account);
}
