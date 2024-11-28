package com.example.linky_server.domain.auth.service;

import com.example.linky_server.domain.auth.dataTransferObject.response.TokenResponse;

public interface ITokenService {
    TokenResponse createToken(String accountId,String userName);
}
