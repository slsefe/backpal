package org.example.buckpal.domain;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class ActivityWindow {

    private final List<Activity> activities;

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    public List<Activity> getActivities() {
        return Collections.unmodifiableList(activities);
    }

    /**
     * calculating the balance by summing up the values of all activities within this window.
     */
    public Money calculateBalance(Long accountId) {
        Money withdrawalBalance = activities.stream()
                .filter(activity -> activity.getSourceAccountId().equals(accountId))
                .map(Activity::getMoney)
                .reduce(Money.ZERO, Money::add);
        Money depositBalance = activities.stream()
                .filter(activity -> activity.getTargetAccountId().equals(accountId))
                .map(Activity::getMoney)
                .reduce(Money.ZERO, Money::add);
        return Money.subtract(depositBalance, withdrawalBalance);
    }


    /**
     * the timestamp of the first activity this window
     */
    public LocalDateTime getStartTimestamp() {
        return activities.stream()
                .min(Comparator.comparing(Activity::getTimestamp))
                .orElseThrow(IllegalStateException::new)
                .getTimestamp();
    }

    /**
     * the timestamp of the last activity this window
     */
    public LocalDateTime getEndTimestamp() {
        return activities.stream()
                .max(Comparator.comparing(Activity::getTimestamp))
                .orElseThrow(IllegalStateException::new)
                .getTimestamp();
    }

}
