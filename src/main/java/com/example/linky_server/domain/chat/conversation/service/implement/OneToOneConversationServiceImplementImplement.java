package com.example.linky_server.domain.chat.conversation.service.implement;

import com.example.linky_server.app.dataTransferObject.PageResponse;
import com.example.linky_server.app.exception.BusinessException;
import com.example.linky_server.app.security.UserPrincipal;
import com.example.linky_server.domain.chat.conversation.contant.ConversationType;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.request.CreateConversationRequest;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.request.UpdateConversationRequest;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.response.ConversationResponse;
import com.example.linky_server.domain.chat.conversation.mapper.ConversationMapper;
import com.example.linky_server.domain.chat.conversation.persistence.model.ConversationEntity;
import com.example.linky_server.domain.chat.conversation.persistence.repository.ConversationRepository;
import com.example.linky_server.domain.chat.conversation.persistence.repository.ParticipantRepository;
import com.example.linky_server.domain.chat.conversation.service.IConversationAccessControlService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Service("oneToOneConversationServiceImplement")
@Primary
public class OneToOneConversationServiceImplementImplement extends AbstractConversationServiceImplement {
    public OneToOneConversationServiceImplementImplement(ConversationRepository conversationRepository,
                                                         ParticipantRepository participantRepository,
                                                         ConversationMapper conversationMapper,
                                                         IConversationAccessControlService accessControlService) {
        super(conversationRepository, participantRepository, conversationMapper, accessControlService);
    }

    @Override
    public ConversationResponse initiateConversation(UserPrincipal userRequest,
                                                     CreateConversationRequest request) {
        String userRequestId = userRequest.getId();
        validateCreationRequest(userRequestId, request);
        ConversationEntity newEntity = ConversationEntity.builder()
                .type(ConversationType.PRIVATE)
                .creatorId(userRequestId)
                .build();
        conversationRepository.save(newEntity);
        return conversationMapper.toDTO(newEntity);
    }

    private void validateCreationRequest(String accountRequestId, CreateConversationRequest request) {
        if (request.getType() != ConversationType.PRIVATE) {
            throw new BusinessException();
        }
        if (request.getAccountIds().size() != 1) {
            throw new BusinessException();
        }
        String otherAccountId = request.getAccountIds().getFirst();
        if (conversationRepository.existsPrivateConversationBetweenUsers(accountRequestId, otherAccountId)) {
            throw new BusinessException();
        }
    }

    @Override
    public ConversationResponse updateConversation(UserPrincipal userRequest, UpdateConversationRequest request) {
        return new ConversationResponse();
    }

    @Override
    public PageResponse<ConversationResponse> getAllConversations(UserPrincipal userRequest, int page, int pageSize) {
        return super.getAllConversations(userRequest, page, pageSize);
    }

    @Override
    public PageResponse<ConversationResponse> findConversation(UserPrincipal userRequest, String keyword, int page, int pageSize) {
        return super.findConversation(userRequest, keyword, page, pageSize);
    }

    @Override
    public void deleteConversation(UserPrincipal userRequest, String conversationId) {
        super.deleteConversation(userRequest, conversationId);
    }
}
