package com.example.linky_server.domain.chat.conversation.controller.operation;

import com.example.linky_server.app.security.UserPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public interface GroupConversationOperations extends ConversationTypeOperations{
    @PostMapping("/leave")
    ResponseEntity<?> handleLeaveConversation(UserPrincipal userRequest,
                                              String conversationId);
}
