package org.example.buckpal.application.port.in;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.buckpal.domain.AccountId;
import org.example.buckpal.domain.Money;

@Getter
@RequiredArgsConstructor
public class SendMoneyCommand {

    @NotNull
    private final AccountId sourceAccountId;

    @NotNull
    private final AccountId targetAccountId;

    @NotNull
    @Positive
    private final Money money;
}
