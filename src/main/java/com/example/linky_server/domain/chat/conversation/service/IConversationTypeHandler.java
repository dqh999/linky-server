package com.example.linky_server.domain.chat.conversation.service;

import com.example.linky_server.app.security.UserPrincipal;
import com.example.linky_server.domain.chat.conversation.persistence.model.ConversationEntity;

import java.util.List;

public interface IConversationTypeHandler {
    void addParticipants(UserPrincipal userRequest,
                         ConversationEntity conversationEntity,
                         List<String> accountIds);

    default void validateParticipantLimit(List<String> accountIds, int requiredSize) {
        if (accountIds.size() != requiredSize) {
            throw new IllegalArgumentException("Invalid number of participants. Expected: " + requiredSize);
        }
    }
}
