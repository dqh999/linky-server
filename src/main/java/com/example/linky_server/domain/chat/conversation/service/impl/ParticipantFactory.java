package com.example.linky_server.domain.chat.conversation.service.impl;

import com.example.linky_server.domain.chat.conversation.contant.ParticipantRole;
import com.example.linky_server.domain.chat.conversation.persistence.model.ParticipantEntity;
import com.example.linky_server.domain.chat.conversation.persistence.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantFactory{
    private final ParticipantRepository participantRepository;

    public ParticipantEntity createEntity(String conversationId,
                                                String accountId,
                                                ParticipantRole role) {
        ParticipantEntity newEntity = buildEntity(conversationId, accountId, role);
        participantRepository.save(newEntity);
        return newEntity;
    }
    private ParticipantEntity buildEntity(String conversationId,
                                           String accountId,
                                           ParticipantRole role) {
        return ParticipantEntity.builder()
                .conversationId(conversationId)
                .accountId(accountId)
                .role(role)
                .build();
    }
    public List<ParticipantEntity> createEntities(String conversationId,
                                           List<String> accountIds) {
        List<ParticipantEntity> newEntities = new ArrayList<>();
        ParticipantRole roleMember = ParticipantRole.MEMBER;
        accountIds.forEach(accountId -> {
            ParticipantEntity newEntity = buildEntity(conversationId, accountId, roleMember);
            newEntities.add(newEntity);
        });
        participantRepository.saveAll(newEntities);
        return newEntities;
    }
    public Page<ParticipantEntity> getAllParticipants(String conversationId,
                                                      PageRequest pageRequest){
        return participantRepository.findAll(pageRequest);
    };
}
