package com.azuryn.commerce.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getHelloMessage() {
        return "Hello from Azuryn Commerce";
    }
}