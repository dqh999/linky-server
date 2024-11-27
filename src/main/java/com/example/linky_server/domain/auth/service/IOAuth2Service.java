package com.example.linky_server.domain.auth.service;

import com.example.linky_server.domain.auth.contant.OAuth2Type;
import com.example.linky_server.domain.auth.dataTransferObject.OAuth2DTO;

public interface IOAuth2Service {
    String generateAuthUrl(OAuth2Type type);
    OAuth2DTO authenticate(OAuth2Type type,
                           String code);
}
