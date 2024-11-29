package com.example.linky_server.domain.chat.conversation.contant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum ConversationType {
    PRIVATE("PRIVATE"),
    GROUP("GROUP");
    private final String type;
}
