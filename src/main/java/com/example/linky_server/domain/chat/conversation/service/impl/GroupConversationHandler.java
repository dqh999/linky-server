package com.example.linky_server.domain.chat.conversation.service.impl;

import com.example.linky_server.domain.chat.conversation.dataTransferObject.response.ConversationResponse;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.response.ParticipantResponse;
import com.example.linky_server.domain.chat.conversation.persistence.model.ConversationEntity;
import com.example.linky_server.domain.chat.conversation.service.IConversationTypeHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.linky_server.app.security.UserPrincipal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupConversationHandler  implements IConversationTypeHandler {
    private final ParticipantFactory participantFactory;
    @Override
    public ParticipantResponse addParticipants(UserPrincipal userRequest,
                                               ConversationEntity conversationEntity,
                                               List<String> accountIds) {
        return null;
    }

    @Override
    public ConversationResponse getConversationDetails(UserPrincipal userRequest, ConversationEntity conversationEntity) {
        return null;
    }
}
