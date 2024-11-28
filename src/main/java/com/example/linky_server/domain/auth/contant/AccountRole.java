package com.example.linky_server.domain.auth.contant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public enum AccountRole {
    USER("USER");

    private final String role;
}
