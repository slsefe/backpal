package org.example.buckpal.application.service;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.example.buckpal.application.port.in.SendMoneyCommand;
import org.example.buckpal.application.port.in.SendMoneyUseCase;
import org.example.buckpal.application.port.out.UpdateAccountStatePort;
import org.example.buckpal.domain.AccountId;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class SendMoneyService implements SendMoneyUseCase {

    private final UpdateAccountStatePort updateAccountStatePort;

    @Override
    public boolean sendMoney(SendMoneyCommand command) {
        // todo: validate business rule
        requireAccountExists(command.getSourceAccountId());
        requireAccountExists(command.getTargetAccountId());
        // todo: manipulate model state
        // todo: return output
        return false;
    }

    private void requireAccountExists(AccountId accountId) {
        // todo: check if the account actually exists in the database
    }
}
