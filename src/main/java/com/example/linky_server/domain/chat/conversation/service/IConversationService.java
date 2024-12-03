package com.example.linky_server.domain.chat.conversation.service;

import com.example.linky_server.app.dataTransferObject.PageResponse;
import com.example.linky_server.app.security.UserPrincipal;
import com.example.linky_server.domain.chat.conversation.contant.ParticipantRole;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.request.AddParticipantRequest;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.request.CreateConversationRequest;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.request.UpdateConversationRequest;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.response.ConversationResponse;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.response.ParticipantResponse;



public interface IConversationService {
    ConversationResponse createConversation(UserPrincipal userRequest,
                                            CreateConversationRequest request);
    ConversationResponse updateConversation(UserPrincipal userRequest,
                                            UpdateConversationRequest request);
    ConversationResponse getConversation(UserPrincipal userRequest,String conversationId);
    PageResponse<ConversationResponse> getAllConversations(UserPrincipal userRequest);
    void deleteConversation(UserPrincipal userRequest,String conversationId);
    ParticipantResponse addParticipant(UserPrincipal userRequest,
                                       AddParticipantRequest request);
    void removeParticipant(UserPrincipal userRequest,
                           String conversationId,
                           String participantId);
    void changeRole(UserPrincipal userRequest,
                    String conversationId,
                    String participantId,
                    ParticipantRole newRole);
}
