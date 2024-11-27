package com.example.linky_server.domain.auth.persistence.model;

import com.example.linky_server.common.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Table(name = "tbl_user_tokens")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TokenEntity extends BaseEntity {
    @Column(name = "account_id", nullable = false)
    String accountId;
    String value;
    @Column(name = "issued_at")
    Date issuedAt;
    @Column(name = "expires_at")
    Date expiresAt;
    @Column(name = "refresh_token")
    String refreshToken;
    @Column(name = "refresh_expires_at")
    Date refreshExpiresAt;
    @Column(name = "device_info")
    String deviceInfo;
    @Column(name = "ip_address")
    String ipAddress;
}
