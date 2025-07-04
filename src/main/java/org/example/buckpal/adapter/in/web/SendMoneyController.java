package org.example.buckpal.adapter.in.web;


import lombok.RequiredArgsConstructor;
import org.example.buckpal.application.port.in.SendMoneyCommand;
import org.example.buckpal.application.port.in.SendMoneyUseCase;
import org.example.buckpal.domain.AccountId;
import org.example.buckpal.domain.Money;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/accounts/sendMoney")
@RequiredArgsConstructor
public class SendMoneyController {
    private final SendMoneyUseCase sendMoneyUseCase;

    @PostMapping("{sourceAccountId}/{targetAccountId}/{amount}")
    void sendMoney(@PathVariable("sourceAccountId") Long sourceAccountId,
                   @PathVariable("targetAccountId") Long targetAccountId,
                   @PathVariable("amount") Long amount) {
        SendMoneyCommand sendMoneyCommand = new SendMoneyCommand(new AccountId(sourceAccountId),
                new AccountId(targetAccountId), Money.of(amount));
        sendMoneyUseCase.sendMoney(sendMoneyCommand);
    }
}
