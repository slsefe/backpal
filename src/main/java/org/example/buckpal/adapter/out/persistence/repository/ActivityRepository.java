package org.example.buckpal.adapter.out.persistence.repository;

import org.example.buckpal.adapter.out.persistence.entity.ActivityJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityJpaEntity, Long> {

    @Query("select a from ActivityJpaEntity a where a.ownerAccountId = :ownerAccountId")
    List<ActivityJpaEntity> findByOwnerSince(@Param("ownerAccountId") Long ownerAccountId);

    @Query("select sum(a.amount) from ActivityJpaEntity a " +
            "where a.ownerAccountId = : accoundId " +
            "and a.targetAccountId = :accountId " +
            "and a.timestamp < :until")
    Long getDepositBalanceUntil(@Param("accountId") Long accountId, @Param("until") LocalDateTime until);

    @Query("select sum(a.amount) from ActivityJpaEntity a " +
            "where a.ownerAccountId = : accoundId " +
            "and a.sourceAccountId = :accountId " +
            "and a.timestamp < :until")
    Long getWithdrawalBalanceUntil(@Param("accountId") Long accountId, @Param("until") LocalDateTime until);
}
