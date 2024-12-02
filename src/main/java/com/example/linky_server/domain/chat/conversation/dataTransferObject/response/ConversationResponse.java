package com.example.linky_server.domain.chat.conversation.dataTransferObject.response;

import com.example.linky_server.domain.chat.conversation.contant.ConversationType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConversationResponse {
    String id;
    ConversationType type;
    String thumbnail;
    String name;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
