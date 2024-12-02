package com.example.linky_server.domain.chat.conversation.controller;


import com.example.linky_server.app.dataTransferObject.ApiResponse;
import com.example.linky_server.app.security.UserPrincipal;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.request.AddParticipantRequest;
import com.example.linky_server.domain.chat.conversation.service.IConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat/participant")
@RequiredArgsConstructor
public class ParticipantController {
    private final IConversationService conversationService;
    @PostMapping
    public ResponseEntity<?> handleAddParticipant(
            @AuthenticationPrincipal UserPrincipal userRequest,
            @RequestBody AddParticipantRequest request
    ) {
        var res = conversationService.addParticipant(userRequest, request);
        return ApiResponse.build()
                .withCode(200)
                .withData(res)
                .withMessage("Add participant success")
                .toEntity();
    }
}
