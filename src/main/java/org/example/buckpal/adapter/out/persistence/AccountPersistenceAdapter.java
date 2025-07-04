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
import org.example.buckpal.domain.AccountId;
import org.example.buckpal.domain.Activity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountStatePort {
    
    private final AccountRepository accountRepository;
    
    private final ActivityRepository activityRepository;

    private final AccountMapper accountMapper;
    
    @Override
    public Account loadAccount(AccountId accountId, LocalDateTime since) {
        AccountJpaEntity account = accountRepository.findById(accountId.getId()).orElseThrow(RuntimeException::new);

        List<ActivityJpaEntity> activities = activityRepository.findByOwnerSince(account.getId(), since);

        Long withdrawalBalance = activityRepository.getWithdrawalBalanceUntil(account.getId(), since);

        Long depositBalance = activityRepository.getDepositBalanceUntil(account.getId(), since);

        return accountMapper.mapToDomainEntity(account, activities, withdrawalBalance, depositBalance);

    }

    @Override
    public void updateActivities(Account account) {
        for (Activity activity : account.getActivityWindow().getActivities()) {
            if (activity.getAccountId() == null) {
                activityRepository.save(accountMapper.mapToJpaEntity(activity));
            }
        }

    }
}
