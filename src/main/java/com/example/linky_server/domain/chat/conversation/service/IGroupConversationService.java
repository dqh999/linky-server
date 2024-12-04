package com.example.linky_server.domain.chat.conversation.service;

import com.example.linky_server.app.security.UserPrincipal;

public interface IGroupConversationService {
    void addUserToGroup(String conversationId,
                        String userId);
    void leaveConversation(UserPrincipal userRequest, String conversationId);
}
