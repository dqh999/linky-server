package com.example.linky_server.domain.auth.service.impl;

import com.example.linky_server.domain.auth.contant.AccountRole;
import com.example.linky_server.domain.auth.contant.OAuth2Type;
import com.example.linky_server.domain.auth.dataTransferObject.GoogleOAuth2DTO;
import com.example.linky_server.domain.auth.persistence.model.AccountEntity;
import com.example.linky_server.domain.auth.persistence.repository.AccountRepository;
import com.example.linky_server.domain.auth.service.IOAuth2Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoogleOAuth2Handler implements IOAuth2Service {
    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    private String clientId;
    @Value("${spring.security.oauth2.client.registration.google.client-secret}")
    private String clientSecret;
    @Value("${spring.security.oauth2.client.registration.google.redirect-uri}")
    private String redirectUri;
    @Value("${spring.security.oauth2.client.registration.google.scope}")
    private String scope;
    @Value("${spring.security.oauth2.client.provider.user-info-uri}")
    private String userInfoUri;
    private final AccountRepository accountRepository;
    @Override
    public String generateAuthUrl(OAuth2Type type) {
        List<String> scopes = List.of(scope.split(","));
        GoogleAuthorizationCodeRequestUrl requestUrl = new GoogleAuthorizationCodeRequestUrl(
                clientId,
                clientSecret,
                scopes
        );
        return requestUrl.build();
    }

    @Override
    public AccountEntity authenticate(OAuth2Type type, String code) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        try {
            NetHttpTransport httpTransport = new NetHttpTransport();
            GsonFactory gsonFactory = new GsonFactory();
            GoogleTokenResponse token = new GoogleAuthorizationCodeTokenRequest(
                    httpTransport, gsonFactory,
                    clientId, clientSecret,
                    code,
                    redirectUri
            ).execute();
            String accessToken = token.getAccessToken();

            restTemplate.getInterceptors().add((req, body, executionContext) -> {
                req.getHeaders().set("Authorization", "Bearer " + accessToken);
                return executionContext.execute(req, body);
            });
            ResponseEntity<String> response = restTemplate.getForEntity(userInfoUri, String.class);
            GoogleOAuth2DTO dto = new ObjectMapper().readValue(response.getBody(), GoogleOAuth2DTO.class);
            return getOrCreateAccount(dto);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    private AccountEntity getOrCreateAccount(GoogleOAuth2DTO dto) {
        return accountRepository.findByEmail(dto.getEmail())
                .orElseGet(() -> {
                    AccountEntity newEntity = AccountEntity.builder()
                            .role(AccountRole.USER)
                            .oauthProvider(OAuth2Type.GOOGLE.getType())
                            .oauthAccountId(dto.getSub())
                            .email(dto.getEmail())
                            .build();
                    accountRepository.save(newEntity);
                    return newEntity;
                });
    }
}
