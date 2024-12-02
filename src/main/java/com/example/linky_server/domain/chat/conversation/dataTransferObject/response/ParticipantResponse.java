package com.example.linky_server.domain.chat.conversation.dataTransferObject.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParticipantResponse {
    String id;
    String accountId;
    String name;
    String avatar;
}
