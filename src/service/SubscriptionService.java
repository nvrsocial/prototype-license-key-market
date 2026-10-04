package service;

import back.KeyGenerator;
import entity.*;

import java.time.LocalDateTime;

public class SubscriptionService {

    private final KeyGenerator keyGenerator = new KeyGenerator();

    private long keyId = 1;

    public void buy(User user, ProductPlan newPlan) {

        Subscription currentSubscription = user.getSubscription();

        if (currentSubscription != null && currentSubscription.getExpiresAt().isAfter(LocalDateTime.now())) {

            ProductPeriod currentPeriod = currentSubscription.getProductPlan().getProductPeriod();
            ProductPeriod newPeriod = newPlan.getProductPeriod();

            if (newPeriod.getLvl() <= currentPeriod.getLvl()) {
                throw new IllegalStateException("You cannot downgrade or buy the same active subscription");
            }
        }

        LocalDateTime startedAt = LocalDateTime.now();
        LocalDateTime expiresAt = calculateExpiresAt(startedAt, newPlan.getProductPeriod());

        String generatedKey = keyGenerator.keyGeneration();

        ProductKey newProductKey = new ProductKey(keyId++, generatedKey);
        Subscription newSubscription = new Subscription(newPlan, startedAt, expiresAt);

        user.setSubscription(newSubscription);
        user.setProductKey(newProductKey);
    }


    private LocalDateTime calculateExpiresAt(LocalDateTime startedAt, ProductPeriod period) {
        return switch (period) {
            case ONE_WEEK -> startedAt.plusWeeks(1);
            case ONE_MONTH -> startedAt.plusMonths(1);
            case THREE_MONTHS -> startedAt.plusMonths(3);
        };
    }
}