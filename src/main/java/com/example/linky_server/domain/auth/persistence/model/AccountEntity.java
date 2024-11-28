package com.example.linky_server.domain.auth.persistence.model;

import com.example.linky_server.common.model.BaseEntity;
import com.example.linky_server.domain.auth.contant.AccountRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tbl_user_accounts")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    AccountRole role;
    @Column(name = "user_name",unique = true)
    String userName;
    @Column(name = "phone_number",unique = true)
    String phoneNumber;
    String email;
    String password;
    @Column(name = "oauth_provider")
    String oauthProvider;
    @Column(name = "oauth_account_id")
    String oauthAccountId;
    @Column(name = "is_active")
    Boolean isActive;
}
