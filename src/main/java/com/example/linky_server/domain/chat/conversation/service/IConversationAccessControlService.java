package com.example.linky_server.domain.chat.conversation.service;

public interface IConversationAccessControlService {
    void authorizeConversationAccess(String accountId,
                                     String conversationId);
    void checkAdminAccess(String accountId, String conversationId);
    void checkMessageAccess(String accountId, String conversationId);
}
