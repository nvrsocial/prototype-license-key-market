import entity.Product;
import entity.ProductPeriod;
import entity.ProductPlan;
import entity.User;
import service.SubscriptionService;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        Product product = new Product(1, "Destruction", "Simple mod");

        ProductPlan oneWeekPlan = new ProductPlan(1, product, ProductPeriod.ONE_WEEK, new BigDecimal("4.99"));

        ProductPlan oneMonthPlan = new ProductPlan(2, product, ProductPeriod.ONE_MONTH, new BigDecimal("9.99"));

        ProductPlan threeMonthsPlan = new ProductPlan(3, product, ProductPeriod.THREE_MONTHS, new BigDecimal("19.99"));

        User vasya = new User(1, "Vasya", "vasya@xyz.com", "1234");

        SubscriptionService subscriptionService = new SubscriptionService();


        System.out.println("=== USER CREATED ===");
        printUserState(vasya);


        System.out.println("\n=== BUY ONE WEEK ===");

        subscriptionService.buy(vasya, oneWeekPlan);

        printUserState(vasya);


        System.out.println("\n=== UPGRADE TO ONE MONTH ===");

        subscriptionService.buy(vasya, oneMonthPlan);

        printUserState(vasya);


        System.out.println("\n=== UPGRADE TO THREE MONTHS ===");

        subscriptionService.buy(vasya, threeMonthsPlan);

        printUserState(vasya);


        System.out.println("\n=== TRY DOWNGRADE TO ONE WEEK ===");

        try {
            subscriptionService.buy(vasya, oneWeekPlan);

            printUserState(vasya);

        } catch (IllegalStateException exception) {

            System.out.println("Purchase error: " + exception.getMessage());
        }


        System.out.println("\n=== TRY DOWNGRADE TO ONE MONTH ===");

        try {

            subscriptionService.buy(vasya, oneMonthPlan);

            printUserState(vasya);

        } catch (IllegalStateException exception) {

            System.out.println("Purchase error: " + exception.getMessage());
        }
    }


    private static void printUserState(User user) {

        System.out.println("User: " + user.getName());
        System.out.println("Email: " + user.getEmail());

        if (user.getSubscription() == null) {

            System.out.println("Subscription: none");
            System.out.println("Key: none");

            return;
        }

        System.out.println("Product: " + user.getSubscription().getProductPlan().getProduct().getName());

        System.out.println("Plan: " + user.getSubscription().getProductPlan().getProductPeriod());

        System.out.println("Price: " + user.getSubscription().getProductPlan().getBigDecimal());

        System.out.println("Started at: " + user.getSubscription().getStartedAt());

        System.out.println("Expires at: " + user.getSubscription().getExpiresAt());

        System.out.println("Key: " + user.getProductKey().getKey());
    }
}