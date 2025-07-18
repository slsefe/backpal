package org.example.buckpal.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.example.buckpal.adapter.out.persistence.converter.AccountMapper;
import org.example.buckpal.adapter.out.persistence.entity.AccountJpaEntity;
import org.example.buckpal.adapter.out.persistence.entity.ActivityJpaEntity;
import org.example.buckpal.adapter.out.persistence.repository.AccountRepository;
import org.example.buckpal.adapter.out.persistence.repository.ActivityRepository;
import org.example.buckpal.application.port.out.LoadAccountPort;
import org.example.buckpal.application.port.out.UpdateAccountStatePort;
import org.example.buckpal.domain.Account;
import org.example.buckpal.domain.Activity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountStatePort {

    private final AccountRepository accountRepository;

    private final ActivityRepository activityRepository;

    private final AccountMapper accountMapper;

    @Override
    public Account loadAccount(Long accountId) {
        AccountJpaEntity account = accountRepository.findById(accountId).orElseThrow(RuntimeException::new);

        List<ActivityJpaEntity> activities = activityRepository.findByOwnerSince(accountId);

        return accountMapper.mapToDomainEntity(account, activities);
    }

    @Override
    public void updateActivities(Account account) {
        List<Activity> activities = account.getActivityWindow().getActivities().stream()
                .filter(activity -> activity.getId() == null)
                .toList();
        activityRepository.saveAll(accountMapper.mapToActivityJpaEntity(activities));
    }
}
