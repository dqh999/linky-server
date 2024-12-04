package com.example.linky_server.domain.chat.conversation.controller.operation;

import com.example.linky_server.app.security.UserPrincipal;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.request.CreateConversationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public interface ConversationTypeOperations {
    @PostMapping
    ResponseEntity<?> handleCreateConversation(UserPrincipal userRequest, CreateConversationRequest request);

}
