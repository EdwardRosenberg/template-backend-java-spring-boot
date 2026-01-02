package com.example.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HelloWorldControllerTests {

    @Autowired
    private HelloWorldController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    void helloReturnsHelloWorld() {
        String response = controller.hello();
        assertThat(response).isEqualTo("Hello World!");
    }
}
