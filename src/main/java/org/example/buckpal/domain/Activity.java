package org.example.buckpal.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class Activity {

    private Long id;

    private final Long ownerAccountId;

    private final Long sourceAccountId;

    private final Long targetAccountId;

    private final LocalDateTime timestamp;

    private final Money money;

}
