package com.example.linky_server.domain.chat.conversation.service.impl;

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
    public void addParticipants(UserPrincipal userRequest,
                                ConversationEntity conversationEntity,
                                List<String> accountIds) {

    }
}
