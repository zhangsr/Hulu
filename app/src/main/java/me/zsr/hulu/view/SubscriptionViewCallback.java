package me.zsr.hulu.view;

import me.zsr.rssbean.Subscription;

public interface SubscriptionViewCallback {
    void onSubscriptionClick(Subscription subscription);
    void onSubscriptionLongClick(Subscription subscription);
}
