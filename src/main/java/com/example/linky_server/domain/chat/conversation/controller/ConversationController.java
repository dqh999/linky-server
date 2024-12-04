package com.example.linky_server.domain.chat.conversation.controller;

import com.example.linky_server.app.dataTransferObject.ApiResponse;
import com.example.linky_server.app.security.UserPrincipal;
import com.example.linky_server.domain.chat.conversation.controller.operation.ConversationOperations;
import com.example.linky_server.domain.chat.conversation.service.IConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat/conversation")
@RequiredArgsConstructor
public class ConversationController implements ConversationOperations {
    private final IConversationService conversationService;

    @Override
    public ResponseEntity<?> handleGetAllConversations(
            @AuthenticationPrincipal UserPrincipal userRequest,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize
            ) {
        var res = conversationService.getAllConversations(userRequest, page, pageSize);
        return ApiResponse.build()
                .withData(res)
                .toEntity();
    }
}
