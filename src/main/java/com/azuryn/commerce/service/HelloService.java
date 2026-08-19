package com.azuryn.commerce.service;

import com.azuryn.commerce.dto.HelloResponse;
import org.springframework.stereotype.Service;
import com.azuryn.commerce.dto.HelloRequest;

@Service
public class HelloService {

    public HelloResponse getHelloMessage(HelloRequest request) {
        return new HelloResponse("Hello " + request.name() + " from Azuryn Commerce") ;
    }
}