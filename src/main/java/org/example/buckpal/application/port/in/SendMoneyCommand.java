package org.example.buckpal.application.port.in;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public class SendMoneyCommand {

    @NotNull
    private final Long userId;

    @NotNull
    private final Long sourceAccountId;

    @NotNull
    private final Long targetAccountId;

    @NotNull
    @Positive
    private final BigDecimal money;
}
