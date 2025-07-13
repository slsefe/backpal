package org.example.buckpal.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Account {

    private final Long id;

    private final ActivityWindow activityWindow;

    public Money calculateBalance() {
        return this.activityWindow.calculateBalance(this.id);
    }

    public static Account withoutId(ActivityWindow activityWindow) {
        return new Account(null, activityWindow);
    }

    public static Account withId(Long accountId, ActivityWindow activityWindow) {
        return new Account(accountId, activityWindow);
    }

    public Optional<Long> getId() {
        return Optional.ofNullable(id);
    }

    public boolean withdraw(Money money, Long targetAccountId) {
        if (!mayWithDraw(money)) {
            return false;
        }
        // add activity for account
        Activity activity = new Activity(null, this.id, this.id, targetAccountId, LocalDateTime.now(), money);
        this.activityWindow.addActivity(activity);
        return true;
    }

    private boolean mayWithDraw(Money money) {
        return Money.add(this.calculateBalance(), money.negate()).isPositive();
    }

    public boolean deposit(Money money, Long sourceAccountId) {
        // add activity for account
        Activity deposit = new Activity(null, this.id, sourceAccountId, this.id, LocalDateTime.now(), money);
        this.activityWindow.addActivity(deposit);
        return true;
    }

}
