package com.example.linky_server.domain.chat.conversation.service;

import com.example.linky_server.app.security.UserPrincipal;

public interface IGroupAdminService {
    void removeUserFromGroup(UserPrincipal userRequest,
                             String conversationId,
                             String accountId);
}
