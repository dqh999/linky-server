package com.example.linky_server.domain.chat.conversation.controller;

<<<<<<< HEAD
<<<<<<< HEAD
import com.example.linky_server.app.dataTransferObject.ApiResponse;
=======
<<<<<<< HEAD
>>>>>>> d4d5cbe5a2b31ef46122e7caf36154099ce8cf7c
=======
>>>>>>> 2c1efaf99e5f53ed9364af5e11158a90c4d61b38
import com.example.linky_server.app.security.UserPrincipal;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.request.CreateConversationRequest;
import com.example.linky_server.domain.chat.conversation.service.IConversationService;
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
    @PostMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> handleCreateConversation(
            @AuthenticationPrincipal UserPrincipal userRequest,
            @RequestBody CreateConversationRequest request
            ){
        var res = conversationService.createConversation(userRequest, request);
        return ResponseEntity.ok(res);
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
public class ConversationController {
>>>>>>> 7ae6b1c8c3392252ee4a32c15d3af247f3bc9717
>>>>>>> d4d5cbe5a2b31ef46122e7caf36154099ce8cf7c
=======
>>>>>>> 2c1efaf99e5f53ed9364af5e11158a90c4d61b38
}
