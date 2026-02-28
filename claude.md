# Claude Code Instructions — template-backend-java-spring-boot

This is a **Tier 2 archetype template** — a ready-to-run Spring Boot microservice scaffold. It inherits Java stack tooling from `template-backend-java` (Tier 1) and organization-wide governance from `template-base` (Tier 0).

## Repository Purpose

Provide a minimal but fully functional Spring Boot application that compiles, passes tests, and has CI green from day one. New projects are scaffolded from this template via the `create-project.yml` workflow.

## Tech Stack

- **Language**: Java 25
- **Framework**: Spring Boot 4.0.1
- **Build tool**: Maven (via Maven Wrapper `./mvnw`)
- **API docs**: Springdoc OpenAPI 2.7.0 (Swagger UI at `/swagger-ui.html`)
- **Test**: JUnit 5 + Spring Boot Test + AssertJ
- **Linter**: Checkstyle (inherited from parent POM via `template-backend-java`)
- **CI**: Calls `template-base` reusable workflow with `backend-tech-stack: java`

## Build Commands

```bash
./mvnw -B clean verify       # Full build + checkstyle + tests
./mvnw -B test                # Run tests only
./mvnw spring-boot:run        # Start the application locally (port 8080)
./mvnw checkstyle:check       # Run checkstyle validation
```

**Always run `./mvnw -B clean verify` before submitting a PR.**

## Project Structure

```
src/main/java/com/example/helloworld/
├── HelloWorldApplication.java     # @SpringBootApplication entry point
└── HelloWorldController.java      # @RestController with /hello endpoint

src/main/resources/
└── application.properties         # Server port, Spring app name, Springdoc config

src/test/java/com/example/helloworld/
├── HelloWorldApplicationTests.java    # Context loads test
├── HelloWorldControllerTests.java     # Controller unit tests
└── SwaggerUITests.java                # Swagger UI integration tests
```

## What You Can Change

- `src/main/java/` — Application code (controllers, services, repositories, DTOs)
- `src/test/java/` — Test code
- `src/main/resources/application.properties` — Application configuration
- `pom.xml` — Add dependencies, but prefer Spring Boot managed versions

## What You Must NOT Change

- Do not remove `spring-boot-starter-web` or `springdoc-openapi-starter-webmvc-ui` from `pom.xml`
- Do not remove the `/hello` or Swagger UI endpoints (they serve as smoke tests)
- Do not change the Spring Boot parent version without verifying all tests pass

## Spring Boot Conventions

- **Package structure**: Use `com.example.helloworld` as the base package (replaced during scaffolding)
- **Controller naming**: `*Controller.java` suffix for REST controllers
- **Test naming**: `*Tests.java` suffix (matches Surefire default includes)
- **Configuration**: Use `application.properties` (not YAML) for consistency with the template
- **Dependency injection**: Prefer constructor injection over field injection
- **REST endpoints**: Use `@GetMapping`, `@PostMapping`, etc. (not `@RequestMapping` with `method=`)
- **API documentation**: Annotate controllers with `@Tag`, `@Operation`, `@ApiResponse` from Springdoc

## Java Conventions

- **Java version**: 25 — use records, sealed classes, pattern matching, text blocks where appropriate
- **No star imports**: Checkstyle enforces `AvoidStarImport`
- **Braces required**: Always use braces for control flow blocks
- **Compiler warnings as errors**: `-Xlint:all -Werror` is inherited from the parent POM
- **Test assertions**: Use AssertJ (`assertThat(...)`) over JUnit assertions

## Testing Conventions

- **Unit tests**: Use `@SpringBootTest` for integration, plain JUnit for pure unit tests
- **Controller tests**: Use `@Autowired` controller + direct method invocation for unit tests; `MockMvc` or `WebTestClient` for HTTP-level tests
- **Naming**: Test methods should describe the behavior: `methodName_condition_expectedResult()` or descriptive sentence style
- **Every new endpoint must have at least one test**

## API Endpoints

| Method | Path | Description |
|---|---|---|
| GET | `/hello` | Hello World greeting |
| GET | `/swagger-ui.html` | Swagger UI |
| GET | `/v3/api-docs` | OpenAPI JSON spec |

## Quality Gates

| Gate | Enforced By | Command |
|---|---|---|
| Compiler warnings | `maven-compiler-plugin` (`-Xlint:all -Werror`) | `./mvnw compile` |
| Checkstyle | `maven-checkstyle-plugin` + inherited `checkstyle.xml` | `./mvnw validate` |
| Unit + integration tests | `maven-surefire-plugin` | `./mvnw test` |
| PR title lint | `pr-title-lint.yml` workflow | Automatic on PR |

## Sync Awareness

**Hierarchy**: `template-base` → `template-backend-java` → **this repo**

Governance files (`.editorconfig`, `.gitignore`, CI workflows, copilot-instructions) are synced from upstream via the platform sync workflow. Do not modify synced files directly — changes will be overwritten.

## Versioning

When making changes, bump the `<version>` in `pom.xml` as part of your commit using semver:

- **PATCH** (e.g., `0.0.1` → `0.0.2`) — bug fixes, doc changes, dependency updates, test additions
- **MINOR** (e.g., `0.0.2` → `0.1.0`) — new endpoints, new dependencies, new features
- **MAJOR** (e.g., `0.1.0` → `1.0.0`) — breaking API changes, Spring Boot major upgrade, removing endpoints

Always update the version in the same commit as your functional changes.

## PR Conventions

- Titles must follow Conventional Commits: `<type>(<scope>): <description>`
- Run `./mvnw -B clean verify` before submitting — build must be green
- Include test coverage for any new endpoint or service method
