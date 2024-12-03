package com.example.linky_server.domain.chat.conversation.service.impl;

import com.example.linky_server.domain.chat.conversation.contant.ParticipantRole;
import com.example.linky_server.domain.chat.conversation.persistence.model.ParticipantEntity;
import com.example.linky_server.infrastructure.websocket.WebSocketHandler;
import com.example.linky_server.infrastructure.websocket.WebSocketTopics;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractConversationHandler {
    public ParticipantEntity createEntity(String conversationId,
                                          String accountId,
                                          ParticipantRole role) {
        return ParticipantEntity.builder()
                .conversationId(conversationId)
                .accountId(accountId)
                .role(role)
                .build();
    };
    public List<ParticipantEntity> createEntities(String conversationId,
                                                  List<String> accountIds){
        List<ParticipantEntity> entities = new ArrayList<>();
        accountIds.forEach(id -> entities.add(createEntity(conversationId, id, ParticipantRole.MEMBER)));
        return entities;
    }
    public void validateParticipantLimit(List<String> accountIds, int requiredSize) {
        if (accountIds.size() > 100){
            throw new RuntimeException();
        }
        if (accountIds.size() != requiredSize) {
            throw new IllegalArgumentException("Invalid number of participants. Expected: " + requiredSize);
        }
    }
    public void sendMessageToParticipants(WebSocketHandler webSocketHandler,
                                          String destinationId,
                                          String type,
                                          Object message) {
        String destination = WebSocketTopics.PRIVATE_MESSAGE + "/" + destinationId;
        webSocketHandler.sendMessage(destination,type,message);
    }
}
