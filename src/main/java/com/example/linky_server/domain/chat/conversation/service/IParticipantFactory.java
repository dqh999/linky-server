package com.example.linky_server.domain.chat.conversation.service;

import com.example.linky_server.domain.chat.conversation.contant.ParticipantRole;
import com.example.linky_server.domain.chat.conversation.persistence.model.ParticipantEntity;

import java.util.List;

public interface IParticipantFactory {
    ParticipantEntity createEntity(String conversationId,
                                   String accountId,
                                   ParticipantRole role);
    List<ParticipantEntity> createEntities(String conversationId,
                                           List<String> accountIds);
    boolean isConversationExists(String conversationId);
}
