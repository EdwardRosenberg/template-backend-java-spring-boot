package com.example.helloworld;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Hello World", description = "Simple greeting API")
public class HelloWorldController {

    @Operation(summary = "Get greeting message", description = "Returns a simple 'Hello World!' greeting")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved greeting message")
    })
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
