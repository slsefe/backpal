package org.example.buckpal.adapter.out.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountJpaEntity {

    @Id
    @GeneratedValue
    private Long id;
}
