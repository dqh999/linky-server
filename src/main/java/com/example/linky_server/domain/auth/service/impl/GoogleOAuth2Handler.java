package com.example.linky_server.domain.auth.service.impl;

import com.example.linky_server.domain.auth.contant.OAuth2Type;
import com.example.linky_server.domain.auth.dataTransferObject.OAuth2DTO;
import com.example.linky_server.domain.auth.service.IOAuth2Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
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
    public OAuth2DTO authenticate(OAuth2Type type, String code) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        try {
            var token = new GoogleAuthorizationCodeTokenRequest(
                    new NetHttpTransport(), new GsonFactory(),
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
            return new ObjectMapper().readValue(response.getBody(), OAuth2DTO.class);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
