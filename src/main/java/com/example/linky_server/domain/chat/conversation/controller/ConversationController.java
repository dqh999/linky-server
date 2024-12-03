package com.example.linky_server.domain.chat.conversation.controller;

import com.example.linky_server.app.dataTransferObject.ApiResponse;
import com.example.linky_server.app.security.UserPrincipal;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.request.CreateConversationRequest;
import com.example.linky_server.domain.chat.conversation.service.IAdminParticipant;
import com.example.linky_server.domain.chat.conversation.service.IConversationService;
import com.example.linky_server.domain.chat.conversation.service.IParticipantHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat/conversation")
@RequiredArgsConstructor
public class ConversationController {
    private final IConversationService conversationService;
    private final IParticipantHandler participantHandler;
    private final IAdminParticipant adminParticipant;
    @PostMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> handleCreateConversation(
            @AuthenticationPrincipal UserPrincipal userRequest,
            @RequestBody CreateConversationRequest request
            ){
        var res = conversationService.createConversation(userRequest, request);
        return ApiResponse.build()
                .withData(res)
                .toEntity();
    }
}
