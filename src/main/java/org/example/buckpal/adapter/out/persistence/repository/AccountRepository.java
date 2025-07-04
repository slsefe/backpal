package org.example.buckpal.adapter.out.persistence.repository;

import org.example.buckpal.adapter.out.persistence.entity.AccountJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountJpaEntity, Long> {
}
