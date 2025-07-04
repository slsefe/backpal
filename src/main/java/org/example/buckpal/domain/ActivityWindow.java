package org.example.buckpal.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ActivityWindow {

    private List<Activity> activities;

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    public Money calculateBalance(AccountId id) {
        return new Money();
    }
}
