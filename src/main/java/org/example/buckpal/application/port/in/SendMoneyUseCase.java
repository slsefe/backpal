package org.example.buckpal.application.port.in;

public interface SendMoneyUseCase {

    public boolean sendMoney(SendMoneyCommand command);
}
