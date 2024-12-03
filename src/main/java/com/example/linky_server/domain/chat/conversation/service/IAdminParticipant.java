package com.example.linky_server.domain.chat.conversation.service;

import com.example.linky_server.app.security.UserPrincipal;

public interface IAdminParticipant extends IParticipantHandler{
    void deleteParticipant(UserPrincipal userRequest,
                           String participantId);
}
