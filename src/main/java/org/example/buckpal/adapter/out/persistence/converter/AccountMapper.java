package org.example.buckpal.adapter.out.persistence.converter;

import org.example.buckpal.adapter.out.persistence.entity.ActivityJpaEntity;
import org.example.buckpal.adapter.out.persistence.entity.AccountJpaEntity;
import org.example.buckpal.domain.Account;
import org.example.buckpal.domain.Activity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {
    Account mapToDomainEntity(AccountJpaEntity account,
                              List<ActivityJpaEntity> activities,
                              Long withdrawalBalance,
                              Long depositBalance);

    ActivityJpaEntity mapToJpaEntity(Activity activity);

}
