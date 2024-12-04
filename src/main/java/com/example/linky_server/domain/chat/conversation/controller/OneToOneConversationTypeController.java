package com.example.linky_server.domain.chat.conversation.controller;


import com.example.linky_server.app.dataTransferObject.ApiResponse;
import com.example.linky_server.app.security.UserPrincipal;
import com.example.linky_server.domain.chat.conversation.controller.operation.ConversationTypeOperations;
import com.example.linky_server.domain.chat.conversation.controller.operation.OneToOneConversationOperations;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.request.CreateConversationRequest;
import com.example.linky_server.domain.chat.conversation.service.IConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat/oneToOne")
public class OneToOneConversationTypeController implements OneToOneConversationOperations {
    private final IConversationService conversationService;

    @Autowired
    public OneToOneConversationTypeController(@Qualifier("oneToOneConversationServiceImplement") IConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @Override
    public ResponseEntity<?> handleCreateConversation(
            @AuthenticationPrincipal UserPrincipal userRequest,
            @RequestBody CreateConversationRequest request
            ){
        var res = conversationService.initiateConversation(userRequest,request);
        return ApiResponse.build()
                .withData(res)
                .toEntity();
    }
}
