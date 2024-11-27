package com.example.linky_server.domain.auth.dataTransferObject.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class AccountResponse {
    private String id;
    private String role;
    private TokenResponse token;
}
