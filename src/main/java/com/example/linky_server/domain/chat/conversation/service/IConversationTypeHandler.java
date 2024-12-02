package com.example.linky_server.domain.chat.conversation.service;

import com.example.linky_server.app.dataTransferObject.PageResponse;
import com.example.linky_server.app.security.UserPrincipal;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.response.ConversationResponse;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.response.ParticipantResponse;
import com.example.linky_server.domain.chat.conversation.persistence.model.ConversationEntity;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IConversationTypeHandler {
    ParticipantResponse addParticipants(UserPrincipal userRequest,
                                        ConversationEntity conversationEntity,
                                        List<String> accountIds);
    default void validateParticipantLimit(List<String> accountIds, int requiredSize) {
        if (accountIds.size() != requiredSize) {
            throw new IllegalArgumentException("Invalid number of participants. Expected: " + requiredSize);
        }
    }
    ConversationResponse getConversationDetails(UserPrincipal userRequest,
                                                ConversationEntity conversationEntity);
}
