package org.example.buckpal.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Money {
    private BigDecimal amount;

    public static Money of(Long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public static Money add(Money money1, Money money2) {
        return new Money(money1.amount.add(money2.amount));
    }

    public Money negate() {
        return new Money(this.amount.negate());
    }

    public boolean isPositive() {
        return this.amount.compareTo(BigDecimal.ZERO) > 0;
    }
}
