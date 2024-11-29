package com.example.linky_server.domain.chat.conversation.persistence.repository;

import com.example.linky_server.domain.chat.conversation.persistence.model.ConversationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepository extends JpaRepository<ConversationEntity,String> {
}
