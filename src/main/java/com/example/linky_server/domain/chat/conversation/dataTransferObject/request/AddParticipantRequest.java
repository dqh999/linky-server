package com.example.linky_server.domain.chat.conversation.dataTransferObject.request;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter @Builder
public class AddParticipantRequest {
    private String conversationId;
    private List<String> accountIds;
}
