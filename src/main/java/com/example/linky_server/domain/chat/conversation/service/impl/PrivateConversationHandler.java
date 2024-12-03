package com.example.linky_server.domain.chat.conversation.service.impl;

import com.example.linky_server.domain.chat.conversation.contant.ConversationEventType;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.response.ConversationResponse;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.response.ParticipantResponse;
import com.example.linky_server.domain.chat.conversation.persistence.model.ConversationEntity;
import com.example.linky_server.domain.chat.conversation.persistence.repository.ParticipantRepository;
import com.example.linky_server.domain.chat.conversation.service.IConversationTypeHandler;
import com.example.linky_server.infrastructure.websocket.WebSocketHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.linky_server.app.security.UserPrincipal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PrivateConversationHandler
        extends AbstractConversationHandler
        implements IConversationTypeHandler {

    private final ParticipantRepository participantRepository;
    private final WebSocketHandler webSocketHandler;

    @Override
    public ParticipantResponse addParticipants(UserPrincipal userRequest,
                                               ConversationEntity conversationEntity,
                                               List<String> accountIds) {
        validateRequest(conversationEntity, accountIds);
        String conversationId = conversationEntity.getId();
        var entities = createEntities(conversationId,accountIds);
        participantRepository.saveAll(entities);

        entities.forEach(entity -> {
            sendMessageToParticipants(webSocketHandler,
                    entity.getAccountId(),
                    ConversationEventType.PARTICIPANT_JOIN.getType(),
                    "");
        });
        return new ParticipantResponse();
    }

    private void validateRequest(ConversationEntity conversationEntity,
                                 List<String> accountIds) {
        validateParticipantLimit(accountIds, 2);
        accountIds.forEach(accountId -> {

        });
    }

    @Override
    public ConversationResponse getConversationDetails(UserPrincipal userRequest,
                                                       ConversationEntity conversationEntity) {
        PageRequest pageRequest = PageRequest.of(0,1);
        return null;
    }

}
