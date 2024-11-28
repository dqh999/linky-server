package com.example.linky_server.domain.auth.persistence.repository;

import com.example.linky_server.domain.auth.persistence.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity,String> {
    Optional<AccountEntity> findByEmail(String email);
    boolean existsByEmail(String email);
}
