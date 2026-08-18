package com.azuryn.commerce.service;

import com.azuryn.commerce.dto.HelloResponse;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public HelloResponse getHelloMessage() {
        return new HelloResponse("Hello from Azuryn Commerce") ;
    }
}