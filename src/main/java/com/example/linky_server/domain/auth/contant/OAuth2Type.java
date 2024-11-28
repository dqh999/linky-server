package com.example.linky_server.domain.auth.contant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum OAuth2Type {
    GOOGLE("GOOGLE");

    private final String type;
}
