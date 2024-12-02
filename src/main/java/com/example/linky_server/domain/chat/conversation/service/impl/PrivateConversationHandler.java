package com.example.linky_server.domain.chat.conversation.service.impl;

import com.example.linky_server.domain.chat.conversation.contant.ConversationType;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.response.ConversationResponse;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.response.ParticipantResponse;
import com.example.linky_server.domain.chat.conversation.mapper.ParticipantMapper;
import com.example.linky_server.domain.chat.conversation.persistence.model.ConversationEntity;
import com.example.linky_server.domain.chat.conversation.service.IConversationTypeHandler;
import com.example.linky_server.infrastructure.websocket.WebSocketHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.linky_server.app.security.UserPrincipal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PrivateConversationHandler implements IConversationTypeHandler {
    private final ParticipantFactory participantFactory;
    private final ParticipantMapper participantMapper;
    private final WebSocketHandler webSocketHandler;
    @Override
    public ParticipantResponse addParticipants(UserPrincipal userRequest,
                                               ConversationEntity conversationEntity,
                                               List<String> accountIds) {
        validateRequest(conversationEntity, accountIds);
        String conversationId = conversationEntity.getId();
        var entities = participantFactory.createEntities(conversationId,accountIds);
        return null;
    }

    private void validateRequest(ConversationEntity entity,
                                 List<String> accountIds) {
        if (!entity.getType().equals(ConversationType.PRIVATE)) {
            throw new RuntimeException("private");
        }
        validateParticipantLimit(accountIds, 2);
    }

    @Override
    public ConversationResponse getConversationDetails(UserPrincipal userRequest,
                                                       ConversationEntity conversationEntity) {
        PageRequest pageRequest = PageRequest.of(0,1);
        var entities = participantFactory.getAllParticipants(conversationEntity.getId(),pageRequest);

        return null;
    }
}
