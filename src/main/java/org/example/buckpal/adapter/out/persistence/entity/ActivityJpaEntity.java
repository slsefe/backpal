package org.example.buckpal.adapter.out.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityJpaEntity {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime timestamp;

    private Long ownerAccountId;

    private Long sourceAccountId;

    private Long targetAccountId;

    private BigDecimal amount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
