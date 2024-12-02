package com.example.linky_server.domain.auth.service;

import com.example.linky_server.domain.auth.dataTransferObject.response.TokenResponse;
import com.example.linky_server.domain.auth.persistence.model.TokenEntity;

public interface ITokenService {
    TokenResponse createToken(String accountId,String userName);
    TokenEntity authenticateToken(String accessToken);
}
