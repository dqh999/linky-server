package com.example.linky_server.domain.chat.conversation.persistence.repository;

import com.example.linky_server.domain.chat.conversation.persistence.model.ParticipantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<ParticipantEntity,String> {
}
