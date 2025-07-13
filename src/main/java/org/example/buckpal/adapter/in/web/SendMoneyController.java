package org.example.buckpal.adapter.in.web;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.buckpal.application.port.in.SendMoneyCommand;
import org.example.buckpal.application.port.in.SendMoneyUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/accounts/sendMoney")
@RequiredArgsConstructor
public class SendMoneyController {
    private final SendMoneyUseCase sendMoneyUseCase;

    @PostMapping
    void sendMoney(@Valid @RequestBody SendMoneyCommand sendMoneyCommand) {
        sendMoneyUseCase.sendMoney(sendMoneyCommand);
    }
}
