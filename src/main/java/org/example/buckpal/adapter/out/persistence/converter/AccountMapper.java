package org.example.buckpal.adapter.out.persistence.converter;

import org.example.buckpal.adapter.out.persistence.entity.ActivityJpaEntity;
import org.example.buckpal.adapter.out.persistence.entity.AccountJpaEntity;
import org.example.buckpal.domain.Account;
import org.example.buckpal.domain.Activity;
import org.example.buckpal.domain.ActivityWindow;
import org.example.buckpal.domain.Money;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountMapper {

    public Account mapToDomainEntity(AccountJpaEntity account, List<ActivityJpaEntity> activities) {
        return Account.withId(account.getId(), mapToActivityWindow(activities));
    }

    public ActivityWindow mapToActivityWindow(List<ActivityJpaEntity> activities) {
        List<Activity> mappedActivities = activities.stream().map(this::mapToActivity).toList();
        return new ActivityWindow(mappedActivities);

    }

    public Activity mapToActivity(ActivityJpaEntity activity) {
        return Activity.builder()
                .id(activity.getId())
                .ownerAccountId(activity.getOwnerAccountId())
                .sourceAccountId(activity.getSourceAccountId())
                .targetAccountId(activity.getTargetAccountId())
                .timestamp(activity.getTimestamp())
                .money(Money.of(activity.getAmount()))
                .build();
    }

    public List<ActivityJpaEntity> mapToActivityJpaEntity(List<Activity> activities) {
        return activities.stream().map(this::mapToActivityJpaEntity).toList();
    }

    public ActivityJpaEntity mapToActivityJpaEntity(Activity activity) {
        return ActivityJpaEntity.builder()
                .ownerAccountId(activity.getOwnerAccountId())
                .sourceAccountId(activity.getSourceAccountId())
                .targetAccountId(activity.getTargetAccountId())
                .timestamp(activity.getTimestamp())
                .amount(activity.getMoney().getAmount())
                .build();
    }

}
