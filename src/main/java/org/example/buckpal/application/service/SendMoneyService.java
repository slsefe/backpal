package org.example.buckpal.application.service;

import lombok.RequiredArgsConstructor;
import org.example.buckpal.application.port.in.SendMoneyCommand;
import org.example.buckpal.application.port.in.SendMoneyUseCase;
import org.example.buckpal.application.port.out.UpdateAccountStatePort;


@RequiredArgsConstructor
public class SendMoneyService implements SendMoneyUseCase {

    private final UpdateAccountStatePort updateAccountStatePort;

    @Override
    public boolean sendMoney(SendMoneyCommand command) {
        // todo: validate business rule
        // todo: manipulate model state
        // todo: return output
        return false;
    }
}
