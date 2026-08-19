package com.azuryn.commerce.controller;

import com.azuryn.commerce.dto.HelloRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.azuryn.commerce.dto.HelloResponse;
import com.azuryn.commerce.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @PostMapping("/hello")
    public HelloResponse hello(@Valid @RequestBody HelloRequest request) {
        return helloService.getHelloMessage(request);
    }
}