# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build & Run Commands

```bash
# Build the project
./gradlew build

# Run the application
./gradlew bootRun

# Run all tests
./gradlew test

# Run a single test class
./gradlew test --tests "com.example.demo.DemoApplicationTests"

# Clean build artifacts
./gradlew clean
```

## Project Architecture

This is a **Spring Boot 4.0.3** Instagram clone using **Java 25** and **Gradle**.

### Package Structure

There are two root packages in use:
- `com.example.demo` — Spring Boot main application entry point
- `cloneproject.Instagram` — Domain logic (entities, future services, repositories, controllers)

The domain code lives under `cloneproject.Instagram`, organized by layer:
- `entity/` — JPA entities

### Tech Stack

- **Web:** Spring MVC (`spring-boot-starter-webmvc`)
- **Persistence:** Spring Data JPA / Hibernate (`spring-boot-starter-data-jpa`)
- **Validation:** Bean Validation (`spring-boot-starter-validation`)
- **Database:** H2 (dev/test), MySQL connector included for production
- **Boilerplate reduction:** Lombok (`@Getter`, `@Builder`, `@NoArgsConstructor`)

### Entity Conventions

- Column names use `member_` prefix (e.g., `member_userid`, `member_username`)
- Enums stored as strings (`@Enumerated(EnumType.STRING)`)
- `@Lob` used for long text fields (e.g., `introduce`)
- `@Builder` constructors set default values (e.g., default profile image, `Gender.PRIVATE`)
- Protected no-args constructor via `@NoArgsConstructor(access = AccessLevel.PROTECTED)`

### Current State

Only the entity layer is implemented (`Member`, `Gender`, `ImageType`). The project is ready to add:
- Repository interfaces extending `JpaRepository`
- Service layer
- REST controllers
- Database configuration in `application.properties` (currently only has `spring.application.name=demo`)
