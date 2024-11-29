package com.example.linky_server.domain.chat.conversation.contant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ParticipantRole {
    ADMIN("ADMIN"),
    MEMBER("MEMBER");
    private final String role;
}
