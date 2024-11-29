package com.example.linky_server.domain.chat.conversation.dataTransferObject.request;

import com.example.linky_server.domain.chat.conversation.contant.ConversationType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CreateConversationRequest {
    ConversationType type;
    String name;
    List<String> accountIds;
}
