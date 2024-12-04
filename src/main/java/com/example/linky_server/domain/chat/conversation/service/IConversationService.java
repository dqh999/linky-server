package com.example.linky_server.domain.chat.conversation.service;

import com.example.linky_server.app.dataTransferObject.PageResponse;
import com.example.linky_server.app.security.UserPrincipal;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.request.CreateConversationRequest;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.request.UpdateConversationRequest;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.request.UpdateParticipantRequest;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.response.ConversationResponse;

public interface IConversationService {
    ConversationResponse initiateConversation(UserPrincipal userRequest,
                                              CreateConversationRequest request);
    ConversationResponse updateConversation(UserPrincipal userRequest,
                                            UpdateConversationRequest request);
    ConversationResponse getConversation(UserPrincipal userRequest,
                                         String conversationId);
    PageResponse<ConversationResponse> getAllConversations(UserPrincipal userRequest,
                                                           int page,int pageSize);
    PageResponse<ConversationResponse> findConversation(UserPrincipal userRequest,
                                                        String keyword,
                                                        int page,int pageSize);
    void deleteConversation(UserPrincipal userRequest,
                            String conversationId);
    void changeNickName(UserPrincipal userRequest,
                        String conversationId,
                        UpdateParticipantRequest request);
}
