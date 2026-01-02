package com.example.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SwaggerUITests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void contextLoadsWithSwagger() {
        // Verify that the application context loads successfully with Swagger configured
        assertThat(applicationContext).isNotNull();
    }

    @Test
    void swaggerBeanIsPresent() {
        // Verify that Springdoc OpenAPI beans are loaded
        String[] beanNames = applicationContext.getBeanNamesForType(org.springdoc.core.configuration.SpringDocConfiguration.class);
        assertThat(beanNames).isNotEmpty();
    }
}
