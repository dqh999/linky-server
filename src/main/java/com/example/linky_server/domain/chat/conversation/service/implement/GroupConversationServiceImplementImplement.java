package com.example.linky_server.domain.chat.conversation.service.implement;

import com.example.linky_server.app.security.UserPrincipal;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.request.CreateConversationRequest;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.request.UpdateConversationRequest;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.response.ConversationResponse;
import com.example.linky_server.domain.chat.conversation.mapper.ConversationMapper;
import com.example.linky_server.domain.chat.conversation.persistence.repository.ConversationRepository;
import com.example.linky_server.domain.chat.conversation.persistence.repository.ParticipantRepository;
import com.example.linky_server.domain.chat.conversation.service.IGroupAdminService;
import com.example.linky_server.domain.chat.conversation.service.IConversationAccessControlService;
import com.example.linky_server.domain.chat.conversation.service.IGroupConversationService;
import org.springframework.stereotype.Service;

@Service("groupConversationServiceImplement")
public class GroupConversationServiceImplementImplement extends AbstractConversationServiceImplement implements IGroupConversationService, IGroupAdminService {
    public GroupConversationServiceImplementImplement(ConversationRepository conversationRepository,
                                                      ParticipantRepository participantRepository,
                                                      ConversationMapper conversationMapper,
                                                      IConversationAccessControlService accessControlService) {
        super(conversationRepository, participantRepository, conversationMapper, accessControlService);
    }

    @Override
    public ConversationResponse initiateConversation(UserPrincipal userRequest,
                                                     CreateConversationRequest request) {
        return null;
    }

    @Override
    public ConversationResponse updateConversation(UserPrincipal userRequest, UpdateConversationRequest request) {
        return null;
    }

    @Override
    public void leaveConversation(UserPrincipal userRequest, String conversationId) {

    }

    @Override
    public void addUserToGroup(String conversationId, String userId) {

    }

    @Override
    public void removeUserFromGroup(UserPrincipal userRequest,
                                    String conversationId,
                                    String accountId) {
        accessControlService.checkAdminAccess(accountId, conversationId);

    }

}
