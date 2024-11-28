package com.example.linky_server.domain.auth.controller;

import com.example.linky_server.domain.auth.contant.OAuth2Type;
import com.example.linky_server.domain.auth.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IAccountService accountService;
    @GetMapping("/social-login")
    public ResponseEntity<?> handleSocialLogin(
            @RequestParam("type") OAuth2Type type
            ) {
        String res = accountService.buildOAuth2Url(type);
        return ResponseEntity.ok().body(res);
    }
    @GetMapping("/social-login/callback")
    public ResponseEntity<?> handleSocialLoginCallback(
            @RequestParam("type") OAuth2Type type,
            @RequestParam("code") String authorizationCode
    ){
        var res = accountService.loginOAuth2(type, authorizationCode);
        return ResponseEntity.ok().body(res);
    }
}
