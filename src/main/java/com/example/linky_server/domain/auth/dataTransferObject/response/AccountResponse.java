package com.example.linky_server.domain.auth.dataTransferObject.response;

import com.example.linky_server.domain.auth.contant.AccountRole;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class AccountResponse {
    private String id;
    private AccountRole role;
    private TokenResponse token;
}
