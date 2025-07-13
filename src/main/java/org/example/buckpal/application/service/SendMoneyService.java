package org.example.buckpal.application.service;

import lombok.RequiredArgsConstructor;
import org.example.buckpal.application.port.in.SendMoneyCommand;
import org.example.buckpal.application.port.in.SendMoneyUseCase;
import org.example.buckpal.application.port.out.LoadAccountPort;
import org.example.buckpal.application.port.out.UpdateAccountStatePort;
import org.example.buckpal.domain.Account;
import org.example.buckpal.domain.Money;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class SendMoneyService implements SendMoneyUseCase {

    private final LoadAccountPort loadAccountPort;

    private final UpdateAccountStatePort updateAccountStatePort;

    @Override
    @Transactional
    public boolean sendMoney(SendMoneyCommand command) {
        // check account exist
        Account sourceAccount = loadAccountPort.loadAccount(command.getSourceAccountId());
        if (sourceAccount == null) {
            throw new IllegalArgumentException("Account with id " + command.getSourceAccountId() + " does not exist");
        }
        Account targetAccount = loadAccountPort.loadAccount(command.getTargetAccountId());
        if (targetAccount == null) {
            throw new IllegalArgumentException("Account with id " + command.getTargetAccountId() + " does not exist");
        }

        Money money = Money.of(command.getMoney());
        if (!sourceAccount.withdraw(money, command.getSourceAccountId())) {
            return false;
        }
        if (!targetAccount.deposit(money, command.getTargetAccountId())) {
            return false;
        }

        // record activity
        updateAccountStatePort.updateActivities(sourceAccount);
        updateAccountStatePort.updateActivities(targetAccount);

        return true;
    }

}
