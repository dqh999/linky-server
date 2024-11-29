package com.example.linky_server.domain.chat.conversation.service.impl;

import com.example.linky_server.domain.chat.conversation.contant.ParticipantRole;
import com.example.linky_server.domain.chat.conversation.persistence.model.ParticipantEntity;
import com.example.linky_server.domain.chat.conversation.persistence.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantFactory{
    private final ParticipantRepository participantRepository;

    public <S extends ParticipantEntity> S createEntity(String conversationId,
                                                String accountId,
                                                ParticipantRole role) {

        return null;
    }
    public List<ParticipantEntity> createEntities(String conversationId,
                                           List<String> accountIds) {
        return null;
    }

}
