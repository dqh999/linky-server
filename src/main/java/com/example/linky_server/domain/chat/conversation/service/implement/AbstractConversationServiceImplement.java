package com.example.linky_server.domain.chat.conversation.service.implement;

import com.example.linky_server.app.dataTransferObject.PageResponse;
import com.example.linky_server.app.exception.BusinessException;
import com.example.linky_server.app.security.UserPrincipal;
import com.example.linky_server.domain.chat.conversation.contant.ConversationResponseCode;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.request.CreateConversationRequest;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.request.UpdateParticipantRequest;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.response.ConversationResponse;
import com.example.linky_server.domain.chat.conversation.mapper.ConversationMapper;
import com.example.linky_server.domain.chat.conversation.persistence.model.ConversationEntity;
import com.example.linky_server.domain.chat.conversation.persistence.repository.ConversationRepository;
import com.example.linky_server.domain.chat.conversation.persistence.repository.ParticipantRepository;
import com.example.linky_server.domain.chat.conversation.service.IConversationAccessControlService;
import com.example.linky_server.domain.chat.conversation.service.IConversationService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractConversationServiceImplement implements IConversationService {
    protected final ConversationRepository conversationRepository;
    protected final ParticipantRepository participantRepository;
    protected final ConversationMapper conversationMapper;
    protected final IConversationAccessControlService accessControlService;

    @Autowired
    public AbstractConversationServiceImplement(ConversationRepository conversationRepository,
                                                ParticipantRepository participantRepository,
                                                ConversationMapper conversationMapper,
                                                IConversationAccessControlService accessControlService) {
        this.conversationRepository = conversationRepository;
        this.participantRepository = participantRepository;
        this.conversationMapper = conversationMapper;
        this.accessControlService = accessControlService;
    }
    @Override
    public ConversationResponse getConversation(UserPrincipal userRequest,
                                                String conversationId) {
        accessControlService.authorizeConversationAccess(userRequest.getId(), conversationId);
        ConversationEntity existingEntity = findConversationById(conversationId);
        return conversationMapper.toDTO(existingEntity);
    }
    protected ConversationEntity findConversationById(String conversationId) {
        return conversationRepository.findById(conversationId)
                .orElseThrow(() -> new BusinessException(ConversationResponseCode.CONVERSATION_NOT_FOUND));
    }
    @Override
    public PageResponse<ConversationResponse> getAllConversations(UserPrincipal userRequest,
                                                                  int page, int pageSize) {

        return null;
    }

    @Override
    public PageResponse<ConversationResponse> findConversation(UserPrincipal userRequest,
                                                               String keyword,
                                                               int page, int pageSize) {
        return null;
    }

    @Override
    public void deleteConversation(UserPrincipal userRequest, String conversationId) {

    }
    @Override
    public void changeNickName(UserPrincipal userRequest,
                               String conversationId,
                               UpdateParticipantRequest request) {

    }
}
