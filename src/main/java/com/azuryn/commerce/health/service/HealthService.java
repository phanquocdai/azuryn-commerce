package com.azuryn.commerce.health.service;

import com.azuryn.commerce.health.dto.HealthResponse;
import org.springframework.stereotype.Service;

@Service
public class HealthService {

    public HealthResponse getHealth() {
        return new HealthResponse("ok");
    }
}