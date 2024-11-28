package com.example.linky_server.domain.auth.service.impl;

import com.example.linky_server.domain.auth.dataTransferObject.response.TokenResponse;
import com.example.linky_server.domain.auth.persistence.model.TokenEntity;
import com.example.linky_server.domain.auth.persistence.repository.TokenRepository;
import com.example.linky_server.domain.auth.service.ITokenService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements ITokenService {
    private final TokenRepository tokenRepository;
    @Value("${spring.jwt.expiration}")
    private long expiration;
    @Value("${spring.jwt.expiration-refresh-token}")
    private long expirationRefreshToken;
    @Value("${spring.jwt.secretKeyAccess}")
    private String secretKeyAccess;
    @Override
    public TokenResponse createToken(String accountId,
                                     String userName) {
        Map<String, Object> claims = buildClaims(accountId, userName);
        Date issuedAt = new Date(System.currentTimeMillis());
        Date expiresAt = new Date(issuedAt.getTime() + expiration);
        String accessToken = generateToken(claims, userName, expiresAt);
        String refreshToken = generateRefreshToken();
        Date refreshExpiresAt = new Date(issuedAt.getTime() + expirationRefreshToken);
        TokenEntity newEntity = TokenEntity.builder()
                .accountId(accountId)
                .value(accessToken)
                .issuedAt(issuedAt)
                .expiresAt(expiresAt)
                .refreshToken(refreshToken)
                .refreshExpiresAt(refreshExpiresAt)
                .build();
        tokenRepository.save(newEntity);
        return TokenResponse.builder()
                .accessToken(accessToken)
                .expiresAt(expiresAt)
                .refreshToken(refreshToken)
                .refreshExpiresAt(refreshExpiresAt)
                .build();
    }
    private Map<String,Object> buildClaims(String accountId,
                                           String subject){
        Map<String, Object> claims = new HashMap<>();
        claims.put("accountId", accountId);
        claims.put("subject", subject);
        return claims;
    }
    private String generateToken(Map<String, Object> claims,
                                 String subject,
                                 Date expiresAt) {
        return Jwts.builder()
                .claims(claims)
                .subject(subject)
                .expiration(expiresAt)
                .signWith(getSignInKey(), Jwts.SIG.HS256)
                .compact();
    }
    private SecretKey getSignInKey() {
        byte[] bytes = Decoders.BASE64.decode(secretKeyAccess);
        return Keys.hmacShaKeyFor(bytes);
    }
    private String generateRefreshToken(){
        return UUID.randomUUID().toString();
    }
}
