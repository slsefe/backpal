package org.example.buckpal.adapter.out.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "activity")
@Data
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

    private Long amount;

}
