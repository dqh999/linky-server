package com.example.linky_server.domain.chat.conversation.controller;


import com.example.linky_server.app.dataTransferObject.ApiResponse;
import com.example.linky_server.app.security.UserPrincipal;
import com.example.linky_server.domain.chat.conversation.controller.operation.GroupConversationOperations;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.request.CreateConversationRequest;
import com.example.linky_server.domain.chat.conversation.service.IConversationService;
import com.example.linky_server.domain.chat.conversation.service.IGroupConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat/group")
public class GroupConversationController implements GroupConversationOperations {
    private final IConversationService conversationService;
    private final IGroupConversationService groupConversationService;

    @Autowired
    public GroupConversationController(@Qualifier("groupConversationServiceImplement") IConversationService conversationService,
                                       IGroupConversationService groupConversationService) {
        this.conversationService = conversationService;
        this.groupConversationService = groupConversationService;
    }

    @Override
    public ResponseEntity<?> handleCreateConversation(
            @AuthenticationPrincipal UserPrincipal userRequest,
            @RequestBody CreateConversationRequest request) {
        var res = conversationService.initiateConversation(userRequest, request);
        return ApiResponse.build()
                .withData(res)
                .toEntity();
    }

    @Override
    public ResponseEntity<?> handleLeaveConversation(
            @AuthenticationPrincipal UserPrincipal userRequest,
            @RequestBody String conversationId) {
        groupConversationService.leaveConversation(userRequest, conversationId);
        return ApiResponse.build().toEntity();
    }
}
