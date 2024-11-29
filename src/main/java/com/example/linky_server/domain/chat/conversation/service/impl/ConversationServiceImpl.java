package com.example.linky_server.domain.chat.conversation.service.impl;

import com.example.linky_server.app.security.UserPrincipal;
import com.example.linky_server.domain.chat.conversation.configuration.ConversationConfig;
import com.example.linky_server.domain.chat.conversation.contant.ConversationType;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.request.AddParticipantRequest;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.request.CreateConversationRequest;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.response.ConversationResponse;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.response.ParticipantResponse;
import com.example.linky_server.domain.chat.conversation.persistence.model.ConversationEntity;
import com.example.linky_server.domain.chat.conversation.persistence.repository.ConversationRepository;
import com.example.linky_server.domain.chat.conversation.service.IConversationService;
import com.example.linky_server.domain.chat.conversation.service.IConversationTypeHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class ConversationServiceImpl implements IConversationService {
    private final ConversationRepository conversationRepository;
    private final Map<ConversationType, IConversationTypeHandler> conversationTypeHandler;
    @Override
    public ConversationResponse createConversation(UserPrincipal userRequest,
                                                   CreateConversationRequest request) {
        ConversationEntity newEntity = ConversationEntity.builder()
                .type(request.getType())
                .creatorId(userRequest.getId())
                .name(request.getName())
                .build();
        conversationRepository.save(newEntity);
        List<String> accountIds = request.getAccountIds();
        var buildParticipant = AddParticipantRequest.builder()
                .conversationId(newEntity.getId())
                .accountIds(accountIds)
                .build();

        return null;
    }

    @Override
    public ParticipantResponse addParticipant(UserPrincipal userRequest,
                                              AddParticipantRequest request) {
        String conversationId = request.getConversationId();
        ConversationEntity existingEntity = conversationRepository.findById(conversationId)
                .orElseThrow();
        ConversationType conversationType = existingEntity.getType();
        var conversationHandler = conversationTypeHandler.get(conversationType);
        List<String> accountIds = request.getAccountIds();
        conversationHandler.addParticipants(userRequest,existingEntity,accountIds);
        return null;
    }
}
