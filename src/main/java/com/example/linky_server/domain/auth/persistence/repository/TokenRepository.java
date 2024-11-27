package com.example.linky_server.domain.auth.persistence.repository;

import com.example.linky_server.domain.auth.persistence.model.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<TokenEntity,String> {
}
