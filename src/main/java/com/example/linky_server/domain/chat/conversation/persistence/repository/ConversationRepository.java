package com.example.linky_server.domain.chat.conversation.persistence.repository;

import com.example.linky_server.domain.chat.conversation.contant.ConversationType;
import com.example.linky_server.domain.chat.conversation.persistence.model.ConversationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ConversationRepository extends JpaRepository<ConversationEntity,String> {
    @Query("SELECT c FROM ConversationEntity c " +
            "JOIN ParticipantEntity p1 ON c.id = p1.conversationId " +
            "JOIN ParticipantEntity p2 ON c.id = p2.conversationId " +
            "WHERE c.type = 'PRIVATE' " +
            "AND p1.accountId = :accountId1 " +
            "AND p2.accountId = :accountId2")
    Optional<ConversationEntity> findPrivateConversationBetweenUsers(String accountId1,
                                                                     String accountId2);
    @Query("SELECT COUNT(c) > 0 FROM ConversationEntity c " +
            "JOIN ParticipantEntity p1 ON c.id = p1.conversationId " +
            "JOIN ParticipantEntity p2 ON c.id = p2.conversationId " +
            "WHERE c.type = 'PRIVATE' " +
            "AND p1.accountId = :accountId1 " +
            "AND p2.accountId = :accountId2")
    boolean existsPrivateConversationBetweenUsers(String accountId1, String accountId2);
}
