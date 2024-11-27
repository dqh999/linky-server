package com.example.linky_server.domain.auth.persistence.repository;

import com.example.linky_server.domain.auth.persistence.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity,String> {
}
