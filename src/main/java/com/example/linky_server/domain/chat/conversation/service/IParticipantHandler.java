package com.example.linky_server.domain.chat.conversation.service;


import com.example.linky_server.app.security.UserPrincipal;

public interface IParticipantHandler {
    void leaveConversation(UserPrincipal userRequest,
                           String conversationId);
}
