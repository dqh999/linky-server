package com.example.linky_server.domain.auth.service;

import com.example.linky_server.domain.auth.contant.OAuth2Type;
import com.example.linky_server.domain.auth.persistence.model.AccountEntity;

public interface IOAuth2Service {
    String generateAuthUrl(OAuth2Type type);
    AccountEntity authenticate(OAuth2Type type,
                               String code);
}
