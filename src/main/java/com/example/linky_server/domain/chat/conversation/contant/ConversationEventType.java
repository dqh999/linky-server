package com.example.linky_server.domain.chat.conversation.contant;

import lombok.Getter;

@Getter
public enum ConversationEventType {
    PARTICIPANT_JOIN("PARTICIPANT_JOIN"),
    PARTICIPANT_LEAVE("PARTICIPANT_LEAVE");

    private final String type;

    ConversationEventType(String type) {
        this.type = type;
    }
}
