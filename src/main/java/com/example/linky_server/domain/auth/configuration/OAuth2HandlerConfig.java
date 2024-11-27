package com.example.linky_server.domain.auth.configuration;

import com.example.linky_server.domain.auth.contant.OAuth2Type;
import com.example.linky_server.domain.auth.service.IOAuth2Service;
import com.example.linky_server.domain.auth.service.impl.GoogleOAuth2Handler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EnumMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class OAuth2HandlerConfig {
    private final GoogleOAuth2Handler googleOAuth2Handler;
    @Bean
    public Map<OAuth2Type, IOAuth2Service> oauth2Providers() {
        Map<OAuth2Type, IOAuth2Service> map = new EnumMap<>(OAuth2Type.class);
        map.put(OAuth2Type.GOOGLE, googleOAuth2Handler);
        return map;
    }
}
