package com.example.linky_server.domain.auth.service;

import com.example.linky_server.app.security.UserPrincipal;
import com.example.linky_server.domain.auth.contant.OAuth2Type;
import com.example.linky_server.domain.auth.dataTransferObject.response.AccountResponse;

public interface IAccountService {
    String buildOAuth2Url(OAuth2Type oAuth2Type);
    AccountResponse loginOAuth2(OAuth2Type oAuth2Type,
                                String code);
    UserPrincipal authenticate(String accessToken);
}
