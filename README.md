# Template Backend Java Spring Boot

A Hello World microservice built with Spring Boot 4.0.1 and Java 21.

This template is derived from [template-base](https://github.com/EdwardRosenberg/template-base) and demonstrates a minimal Spring Boot backend application.

## Prerequisites

- Java 21 or higher
- Maven 3.6+

## Building the Application

```bash
mvn clean install
```

## Running the Application

```bash
mvn spring-boot:run
```

Or run the packaged JAR:

```bash
java -jar target/hello-world-service-0.0.1-SNAPSHOT.jar
```

## Testing

Run all tests:

```bash
mvn test
```

## API Endpoints

### GET /hello

Returns a "Hello World!" message.

**Example:**
```bash
curl http://localhost:8080/hello
```

**Response:**
```
Hello World!
```

## API Documentation

This application includes Swagger UI for interactive API documentation and testing.

### Accessing Swagger UI

Once the application is running, you can access the Swagger UI at:

```
http://localhost:8080/swagger-ui.html
```

The Swagger UI provides:
- Interactive API documentation
- Ability to test API endpoints directly from the browser
- Request/response schemas
- HTTP method details

### OpenAPI Specification

The OpenAPI specification (JSON format) is available at:

```
http://localhost:8080/v3/api-docs
```

You can also access the YAML format at:

```
http://localhost:8080/v3/api-docs.yaml
```

### Disabling Swagger for Production

To disable Swagger UI in production environments, add the following to your `application.properties`:

```properties
springdoc.swagger-ui.enabled=false
springdoc.api-docs.enabled=false
```

Or set the environment variable:

```bash
SPRINGDOC_SWAGGER_UI_ENABLED=false
SPRINGDOC_API_DOCS_ENABLED=false
```

## Configuration

The application runs on port 8080 by default. You can change this in `src/main/resources/application.properties`:

```properties
server.port=8080
spring.application.name=hello-world-service
```

## Project Structure

```
.
├── src/
│   ├── main/
│   │   ├── java/com/example/helloworld/
│   │   │   ├── HelloWorldApplication.java    # Main Spring Boot application class
│   │   │   └── HelloWorldController.java     # REST controller with /hello endpoint
│   │   └── resources/
│   │       └── application.properties         # Application configuration
│   └── test/
│       └── java/com/example/helloworld/
│           ├── HelloWorldApplicationTests.java   # Application context test
│           ├── HelloWorldControllerTests.java    # Controller unit tests
│           └── SwaggerUITests.java               # Swagger UI integration tests
├── pom.xml                                     # Maven project configuration
└── README.md                                   # This file
```

## Technology Stack

- **Spring Boot**: 4.0.1
- **Java**: 21
- **Build Tool**: Maven
- **Testing**: JUnit 5, Spring Boot Test
- **API Documentation**: Springdoc OpenAPI 2.7.0 (Swagger UI)

## CI/CD

This template uses GitHub Actions for continuous integration. The CI workflow automatically runs on pushes and pull requests to the `main` and `develop` branches.

The workflow:
- Builds the project using Maven (`mvn -B clean verify`)
- Runs all tests (`mvn -B test`)
- Uses Java 21 with the Temurin distribution
- Leverages a reusable workflow from [template-base](https://github.com/EdwardRosenberg/template-base)

See [`.github/workflows/ci.yml`](.github/workflows/ci.yml) for the complete configuration.

## Configuration Files

This repository includes several configuration files:

- `.editorconfig`: Defines coding styles for various file types
- `.gitignore`: Comprehensive gitignore for Java, Maven, and common IDEs
- `.github/dependabot.yml`: Automated dependency updates for GitHub Actions and Maven
- `.github/workflows/ci.yml`: Continuous Integration workflow

## Contributing

Please see the pull request template for contribution guidelines.

## License

<!-- Add your license information here -->
