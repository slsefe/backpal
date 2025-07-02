package org.example.buckpal.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Activity {

    private AccountId accountId;
    private AccountId sourceAccountId;
    private AccountId targetAccountId;
    private LocalDateTime createdAt;
    private Money money;
}
