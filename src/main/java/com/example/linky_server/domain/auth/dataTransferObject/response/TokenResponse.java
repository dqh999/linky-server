package com.example.linky_server.domain.auth.dataTransferObject.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @Builder
public class TokenResponse {
    private String accessToken;
    private Date expiresAt;
    private String refreshToken;
    private Date refreshExpiresAt;
}
