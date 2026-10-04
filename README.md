# A console-based Java backend prototype for a digital product key store.

The project focuses on implementing the core business logic without external libraries or frameworks. Users can purchase subscriptions for a digital product, receive generated product keys, and upgrade their active subscription according to predefined rules.

# Features:
- User management
- Digital product model
- Multiple subscription plans:
  - 1 week
  - 1 month
  - 3 months
- Different prices for each subscription plan
- Automatic product key generation
- Product key assignment to users
- Subscription start and expiration dates
- Subscription upgrade system
- Upgrade from 1 week to 1 month or 3 months
- Upgrade from 1 month to 3 months
- Prevention of subscription downgrades while the current subscription is active
- New subscription replaces the current subscription instead of extending its remaining duration
- Expired subscriptions allow the user to purchase any available plan
- Separation of entities, business logic, and key generation

# The current version is implemented entirely with Java Core as a console application. The project is intended to later be migrated to Spring Boot, with database persistence, authentication and authorization, REST APIs, and additional microservices.
