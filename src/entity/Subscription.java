package entity;

import java.time.LocalDateTime;

public class Subscription {
    private ProductPlan productPlan;
    private LocalDateTime startedAt;
    private LocalDateTime expiresAt;

    public Subscription(ProductPlan productPlan, LocalDateTime startedAt, LocalDateTime expiresAt) {
        this.productPlan = productPlan;
        this.startedAt = startedAt;
        this.expiresAt = expiresAt;
    }

    public ProductPlan getProductPlan() {
        return productPlan;
    }

    public void setProductPlan(ProductPlan productPlan) {
        this.productPlan = productPlan;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "productPlan=" + productPlan +
                ", startedAt=" + startedAt +
                ", expiresAt=" + expiresAt +
                '}';
    }
}
