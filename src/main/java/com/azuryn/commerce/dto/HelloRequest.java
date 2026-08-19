package com.azuryn.commerce.dto;

import jakarta.validation.constraints.NotBlank;

public record HelloRequest(
        @NotBlank(message = "name must not be blank")
        String name
) {
}