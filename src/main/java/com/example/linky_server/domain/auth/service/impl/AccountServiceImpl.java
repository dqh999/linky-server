package com.example.linky_server.domain.auth.service.impl;

import com.example.linky_server.domain.auth.contant.OAuth2Type;
import com.example.linky_server.domain.auth.dataTransferObject.response.AccountResponse;
import com.example.linky_server.domain.auth.persistence.model.AccountEntity;
import com.example.linky_server.domain.auth.persistence.repository.AccountRepository;
import com.example.linky_server.domain.auth.service.IAccountService;
import com.example.linky_server.domain.auth.service.IOAuth2Service;
import com.example.linky_server.domain.auth.service.ITokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {
    private final Map<OAuth2Type, IOAuth2Service> oauth2Providers;
    private final ITokenService tokenService;
    @Override
    public String buildOAuth2Url(OAuth2Type oAuth2Type) {
        var oauth2Provider = oauth2Providers.get(oAuth2Type);
        return oauth2Provider.generateAuthUrl(oAuth2Type);
    }
    @Override
    public AccountResponse loginOAuth2(OAuth2Type oAuth2Type,
                                       String code) {
        var oauth2Provider = oauth2Providers.get(oAuth2Type);
        AccountEntity accountEntity = oauth2Provider.authenticate(oAuth2Type, code);
        var tokenResponse = tokenService.createToken(accountEntity.getId(),accountEntity.getUserName());
        return AccountResponse.builder()
                .id(accountEntity.getId())
                .role(accountEntity.getRole())
                .token(tokenResponse)
                .build();
    }
}
