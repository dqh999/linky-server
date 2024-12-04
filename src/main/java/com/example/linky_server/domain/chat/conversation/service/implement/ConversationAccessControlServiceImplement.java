package com.example.linky_server.domain.chat.conversation.service.implement;

import com.example.linky_server.domain.chat.conversation.persistence.repository.ParticipantRepository;
import com.example.linky_server.domain.chat.conversation.service.IConversationAccessControlService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConversationAccessControlServiceImplement implements IConversationAccessControlService {
    private final ParticipantRepository participantRepository;
    @Override
    public void authorizeConversationAccess(String accountId,
                                            String conversationId) {

    }

    @Override
    public void checkAdminAccess(String accountId, String conversationId) {

    }

    @Override
    public void checkMessageAccess(String accountId, String conversationId) {

    }
}
