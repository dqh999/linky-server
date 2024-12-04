package com.example.linky_server.domain.chat.conversation.contant;

import com.example.linky_server.app.dataTransferObject.ApiResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum ConversationResponseCode implements ApiResponseCode {
    CONVERSATION_NOT_FOUND("CONVERSATION_NOT_FOUND", 404);

    private final String type;
    private final Integer code;
}
