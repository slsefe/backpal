package org.example.buckpal.domain;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class Money {

    public static final Money ZERO = Money.of(BigDecimal.ZERO);
    @NotNull
    private final BigDecimal amount;

    public static Money of(BigDecimal amount) {
        return new Money(amount);
    }

    public static Money add(Money money1, Money money2) {
        return new Money(money1.amount.add(money2.amount));
    }

    public static Money subtract(Money money1, Money money2) {
        return new Money(money1.amount.subtract(money2.amount));
    }

    public Money plus(Money money) {
        return new Money(this.amount.add(money.amount));
    }

    public Money minus(Money money) {
        return new Money(this.amount.subtract(money.amount));
    }

    public Money negate() {
        return new Money(this.amount.negate());
    }

    public boolean isPositive() {
        return this.amount.compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean isPositiveOrZero() {
        return this.amount.compareTo(BigDecimal.ZERO) >= 0;
    }

    public boolean isNegative() {
        return this.amount.compareTo(BigDecimal.ZERO) < 0;
    }

    public boolean isGreaterThan(Money money) {
        return this.amount.compareTo(money.amount) > 0;
    }

    public boolean isGreaterThanOrEqual(Money money) {
        return this.amount.compareTo(money.amount) >= 0;
    }
}
