package com.example.linky_server.domain.chat.conversation.service.impl;

import com.example.linky_server.app.security.UserPrincipal;
import com.example.linky_server.domain.chat.conversation.service.IAdminParticipant;

public class AdminParticipantHandler implements IAdminParticipant {
    @Override
    public void deleteParticipant(UserPrincipal userRequest, String participantId) {

    }

    @Override
    public void leaveConversation(UserPrincipal userRequest, String conversationId) {

    }
}
